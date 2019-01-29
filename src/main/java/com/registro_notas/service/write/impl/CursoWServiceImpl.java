package com.registro_notas.service.write.impl;

import java.util.UUID;

import com.registro_notas.domain.Curso;
import com.registro_notas.repository.write.CursoWRepository;
import com.registro_notas.service.write.CursoWService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoWServiceImpl implements CursoWService {

    @Autowired
    private CursoWRepository cursoWRepository;

    @Override
    public UUID createCurso(Curso curso) {
        return cursoWRepository.createCurso(curso);
    }

    @Override
    public boolean updateCurso(Curso curso) {
        return cursoWRepository.updateCurso(curso);
    }

    @Override
    public boolean deleteCurso(UUID ui_id_curso) {
        return cursoWRepository.deleteCurso(ui_id_curso);
    }

    
}