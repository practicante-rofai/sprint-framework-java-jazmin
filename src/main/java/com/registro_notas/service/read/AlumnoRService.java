package com.registro_notas.service.read;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Alumno;

public interface AlumnoRService {

    Alumno getAlumno(UUID ui_idalumno);
    List<Alumno> getAlumnos();
}