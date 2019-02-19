package com.registro_notas.repository.read.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.DetalleNCA;
import com.registro_notas.repository.read.DetalleNCARRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DetalleNCARRepositoryImpl implements DetalleNCARRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(DetalleNCARRepositoryImpl.class);

    private DetalleNCA mapDataDetalle(ResultSet rs, int i) throws SQLException {
        DetalleNCA detalle_nca = new DetalleNCA();
        detalle_nca.setUi_id_nota(UUID.fromString(rs.getString("ui_id_nota")));
        detalle_nca.setVc_nombre(rs.getString("vc_nombre"));;
        detalle_nca.setNombre(rs.getString("nombre"));
        detalle_nca.setApellido(rs.getString("apellido"));
        detalle_nca.setNr_nota(rs.getDouble("nr_nota"));
        return detalle_nca;
    }

    @Override
    public DetalleNCA getDetalleNCA(UUID ui_id_nota) {
        DetalleNCA detalle_nca = new DetalleNCA();
        String sql = "SELECT n.ui_id_nota, c.vc_nombre, a.nombre, a.apellido, n.nr_nota FROM registro_notas.notas n JOIN registro_notas.curso c ON  n.ui_id_curso = c.ui_id_curso JOIN registro_notas.alumno a ON n.id_alumno = a.id_alumno WHERE n.ui_id_nota = ?";
        try {
            detalle_nca = jdbcTemplate.queryForObject(sql, new Object[] { ui_id_nota }, this::mapDataDetalle);

        } catch (Exception e) {
            logger.error("SQLException: ", e);
        }
        return detalle_nca;
    }

    @Override
    public List<DetalleNCA> getDetallesNCA() {
        List<DetalleNCA> listDetallesNCA = null;
        String sql = "SELECT n.ui_id_nota, c.vc_nombre, a.nombre, a.apellido, n.nr_nota FROM registro_notas.notas n JOIN registro_notas.curso c ON  n.ui_id_curso = c.ui_id_curso JOIN registro_notas.alumno a ON n.id_alumno = a.id_alumno";
        try {
            listDetallesNCA = jdbcTemplate.query(sql, new Object[] {}, this::mapDataDetalle);
        } catch (EmptyResultDataAccessException e) {
            logger.error("SQLException: ", e);
        }
        return listDetallesNCA;
    }    
}