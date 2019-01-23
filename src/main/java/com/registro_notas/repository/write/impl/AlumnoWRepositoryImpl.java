package com.registro_notas.repository.write.impl;

import java.util.UUID;

import com.registro_notas.domain.Alumno;
import com.registro_notas.repository.write.AlumnoWRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlumnoWRepositoryImpl implements AlumnoWRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(AlumnoWRepositoryImpl.class);

    @Override    
    @Transactional(rollbackFor = Exception.class)
    public UUID createAlumno(Alumno alumno) {
        UUID idGenerated = UUID.randomUUID();
        String sql = "INSERT INTO registro_notas.alumno " + 
        "(id_alumno, nombre, apellido, estado) " + 
        "VALUES(?, ?, ?, true)"; 

        try {
            jdbcTemplate.update(sql, new Object[] { 
                idGenerated, 
                alumno.getNombre(), 
                alumno.getApellido(),
            });
            return null;
        } catch (Exception e) {
            logger.error("Exception:" + e);
            return idGenerated;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAlumno(Alumno alumno) {
        String SQL = "UPDATE registro_notas.alumno "+
                    "SET nombre = ?, apellido = ?, estado = true " +
                    "WHERE id_alumno = ?";
		try {
            jdbcTemplate.update(SQL, new Object[] {
                alumno.getNombre(), 
                alumno.getApellido(),
                alumno.getId_alumno(),
            });
            return true;
		} catch (Exception e) {
            logger.error("Exception:" + e);
			return false;
		}
    }

    @Override
    public boolean deleteAlumno(Alumno alumno) {
        String SQL = "UPDATE registro_notas.alumno "+
                    "SET estado = false "+
                    "WHERE id_alumno = ?";
        try {
            jdbcTemplate.update(SQL, new Object[] {
                alumno.getId_alumno()
            });
            return true;
            } catch (Exception e) {
                        logger.error("Exception:" + e);
            return false;
            }
    }

}