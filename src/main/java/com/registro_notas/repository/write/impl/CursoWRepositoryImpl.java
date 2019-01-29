package com.registro_notas.repository.write.impl;

import java.util.UUID;

import com.registro_notas.domain.Curso;
import com.registro_notas.repository.write.CursoWRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CursoWRepositoryImpl implements CursoWRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CursoWRepositoryImpl.class);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID createCurso(Curso curso) {
        
        UUID idGenerated = UUID.randomUUID();
        String sql = "INSERT INTO registro_notas.curso " + 
        "(ui_id_curso, vc_nombre, estado) " + 
        "VALUES(?, ?, true)"; 

        try {
            jdbcTemplate.update(sql, new Object[] { 
                idGenerated,  
                curso.getVc_nombre(),
            });
            return null;
        } catch (Exception e) {
            logger.error("Exception:" + e);
            return idGenerated;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCurso(Curso curso) {
        String SQL = "UPDATE registro_notas.curso "+
                    "SET vc_nombre = ?, estado = true " +
                    "WHERE ui_id_curso = ?";
		try {
            jdbcTemplate.update(SQL, new Object[] {
                curso.getVc_nombre(), 
                curso.getUi_id_curso(),
            });
            return true;
		} catch (Exception e) {
            logger.error("Exception:" + e);
			return false;
		}
    }

    @Override
    public boolean deleteCurso(UUID ui_id_curso) {
        String SQL = "UPDATE registro_notas.curso" + "SET estado = false " + "WHERE ui_id_curso = ?";
        try {

            jdbcTemplate.update(SQL, new Object[] { ui_id_curso });
            return true;
        } catch (Exception e) {
            logger.error("Exception:" + e);
            return false;
        }
    }
    
    
}