package com.registro_notas.service.write.impl;

import java.util.UUID;

import com.registro_notas.domain.Alumno;
import com.registro_notas.repository.write.AlumnoWRepository;
import com.registro_notas.service.write.AlumnoWService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoWServiceImpl implements AlumnoWService{
    @Autowired
    private AlumnoWRepository alumnoWRepository;

    @Override
    public UUID createAlumno(Alumno alumno) {
        return alumnoWRepository.createAlumno(alumno);
    }

    @Override
    public boolean updateAlumno(Alumno alumno) {
        return alumnoWRepository.updateAlumno(alumno);
    }

    @Override
    public boolean deleteAlumno(UUID id_alumno) {
        return alumnoWRepository.deleteAlumno(id_alumno);
    }

}