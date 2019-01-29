package com.registro_notas.repository.read.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Nota;
import com.registro_notas.repository.read.NotaRRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class NotaRRepositoryImpl implements NotaRRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(NotaRRepositoryImpl.class);

    private Nota mapDataNota(ResultSet rs, int i) throws SQLException {
        Nota nota = new Nota();
        nota.setUi_id_nota(UUID.fromString(rs.getString("ui_id_nota")));
        nota.setUi_id_curso(UUID.fromString(rs.getString("ui_id_curso")));
        nota.setId_alumno(UUID.fromString(rs.getString("id_alumno")));
        nota.setNr_nota(rs.getDouble("nr_nota"));
        return nota;
    }

    @Override
    public Nota getNota(UUID ui_id_nota) {
        Nota nota = new Nota();
        String sql = "SELECT ui_id_nota, ui_id_curso, id_alumno, nr_nota FROM registro_notas.notas WHERE ui_id_nota = ?";
        try {
            nota = jdbcTemplate.queryForObject(sql, new Object[] { ui_id_nota }, this::mapDataNota);

        } catch (Exception e) {
            logger.error("SQLException: ", e);
        }
        return nota;
    }

    @Override
    public List<Nota> getNotas() {
        List<Nota> listNota = null;
        String sql = "SELECT ui_id_nota, ui_id_curso, id_alumno, nr_nota registro_notas.notas";
        try {
            listNota = jdbcTemplate.query(sql, new Object[] {}, this::mapDataNota);
        } catch (EmptyResultDataAccessException e) {
            logger.error("SQLException: ", e);
        }
        return listNota;
    }
    
}