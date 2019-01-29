package com.registro_notas.service.read.impl;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Curso;
import com.registro_notas.repository.read.CursoRRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoRServiceImpl implements CursoRRepository {

    @Autowired
    private CursoRRepository cursoRRepository;

    @Override
    public Curso getCurso(UUID ui_id_curso) {
        return cursoRRepository.getCurso(ui_id_curso);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRRepository.getCursos();
    }

    
}