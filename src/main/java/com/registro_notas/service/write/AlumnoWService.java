package com.registro_notas.service.write;

import java.util.UUID;

import com.registro_notas.domain.Alumno;

public interface AlumnoWService {

    UUID createAlumno(Alumno alumno);
    boolean updateAlumno(Alumno alumno);
}