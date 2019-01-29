package com.registro_notas.repository.read.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Curso;
import com.registro_notas.repository.read.CursoRRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CursoRRepositoryImpl implements CursoRRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CursoRRepositoryImpl.class);

    private Curso mapDataCurso(ResultSet rs, int i) throws SQLException {
        Curso curso = new Curso();
        curso.setUi_id_curso(UUID.fromString(rs.getString("ui_id_alumno")));
        curso.setVc_nombre(rs.getString("vc_nombre"));
        curso.setEstado(rs.getBoolean("estado"));
        return curso;
    }

    @Override
    public Curso getCurso(UUID ui_id_curso) {
        Curso curso = new Curso();
        String sql = "SELECT ui_id_curso, vc_nombre, estado FROM registro_notas.curso WHERE (ui_id_alumno = ?) AND (estado = true)";
        try {
            curso = jdbcTemplate.queryForObject(sql, new Object[] { ui_id_curso }, this::mapDataCurso);

        } catch (Exception e) {
            logger.error("SQLException: ", e);
        }
        return curso;
    }

    @Override
    public List<Curso> getCursos() {
        List<Curso> listCurso = null;
        String sql = "SELECT ui_id_curso, vc_nombre, estado FROM registro_notas.curso WHERE estado = true";
        try {
            listCurso = jdbcTemplate.query(sql, new Object[] {}, this::mapDataCurso);
        } catch (EmptyResultDataAccessException e) {
            logger.error("SQLException: ", e);
        }
        return listCurso;
    }

    
}