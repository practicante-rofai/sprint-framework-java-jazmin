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
        String sql = "INSERT INTO administration.alumno " + 
        "(ui_idalumno, vc_nombre, vc_apellido) " + 
        "VALUES(?, ?, ?)";

        try {
            jdbcTemplate.update(sql, new Object[] { 
                idGenerated, 
                alumno.getVc_nombre(), 
                alumno.getVc_apellido() 
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
        String SQL = "UPDATE administration.user "+
                    "SET vc_name = ?, vc_surname = ?" +
                    "WHERE ui_iduser = ?";
		try {
            jdbcTemplate.update(SQL, new Object[] {
                alumno.getVc_nombre(), 
                alumno.getVc_apellido(),
                alumno.getUi_idalumno()
            });
            return true;
		} catch (Exception e) {
            logger.error("Exception:" + e);
			return false;
		}
    }   
}