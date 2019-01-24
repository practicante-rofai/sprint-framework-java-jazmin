package com.registro_notas.repository.write;

import java.util.UUID;

import com.registro_notas.domain.Alumno;

public interface AlumnoWRepository {

    UUID createAlumno(Alumno alumno);
    boolean updateAlumno(Alumno alumno);
    boolean deleteAlumno(UUID id_alumno);
}