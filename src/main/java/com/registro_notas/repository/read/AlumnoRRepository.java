package com.registro_notas.repository.read;


import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Alumno;

public interface AlumnoRRepository{
    Alumno getAlumno(UUID ui_idalumno);
    List<Alumno> getAlumnos();
}