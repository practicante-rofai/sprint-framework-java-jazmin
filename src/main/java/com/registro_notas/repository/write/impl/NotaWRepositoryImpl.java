package com.registro_notas.repository.write.impl;

import java.util.UUID;

import com.registro_notas.domain.Nota;
import com.registro_notas.repository.write.NotaWRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class NotaWRepositoryImpl implements NotaWRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(NotaWRepositoryImpl.class);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID createNota(Nota nota) {
        UUID idGenerated = UUID.randomUUID();
        String sql = "INSERT INTO registro_notas.notas " + "(ui_id_nota, ui_id_nota, id_alumno, nr_nota) "
                + "VALUES(?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql,
                    new Object[] { idGenerated, nota.getUi_id_curso(), nota.getId_alumno(), nota.getNr_nota() });
            return null;
        } catch (Exception e) {
            logger.error("Exception:" + e);
            return idGenerated;
        }
    }

}