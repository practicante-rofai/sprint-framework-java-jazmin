package com.registro_notas.repository.read.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Alumno;
import com.registro_notas.repository.read.AlumnoRRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoRRepositoryImpl implements AlumnoRRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(AlumnoRRepositoryImpl.class);

    private Alumno mapDataPersona(ResultSet rs, int i) throws SQLException {
        Alumno alumno = new Alumno();
        alumno.setId_alumno(UUID.fromString(rs.getString("id_alumno")));
        alumno.setNombre(rs.getString("nombre"));
        alumno.setApellido(rs.getString("apellido"));
        alumno.setEstado(rs.getBoolean("estado"));
        return alumno;
    }

    @Override
    public Alumno getAlumno(UUID id_alumno) {
        Alumno alumno = new Alumno();
        String sql = "SELECT id_alumno, nombre, apellido, estado FROM registro_notas.alumno WHERE (id_alumno = ?) AND (estado = true)";
        try {
            alumno = jdbcTemplate.queryForObject(sql, new Object[] { id_alumno }, this::mapDataPersona);

        } catch (Exception e) {
            logger.error("SQLException: ", e);
        }
        return alumno;
    }

    @Override
    public List<Alumno> getAlumnos() {
        List<Alumno> listAlumno = null;
        String sql = "SELECT id_alumno, nombre, apellido, estado FROM registro_notas.alumno WHERE estado = true";
        try {
            listAlumno = jdbcTemplate.query(sql, new Object[] {}, this::mapDataPersona);
        } catch (EmptyResultDataAccessException e) {
            logger.error("SQLException: ", e);
        }
        return listAlumno;
    }
}