package com.registro_notas.service.read.impl;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Alumno;
import com.registro_notas.repository.read.AlumnoRRepository;
import com.registro_notas.service.read.AlumnoRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoRServiceImpl implements AlumnoRService{
    @Autowired
    private AlumnoRRepository alumnoRRepository;

    @Override
    public Alumno getAlumno(UUID ui_idalumno) {
        return alumnoRRepository.getAlumno(ui_idalumno);
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnoRRepository.getAlumnos();
    }
    
}