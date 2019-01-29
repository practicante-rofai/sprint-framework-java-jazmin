package com.registro_notas.repository.read;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Curso;

public interface CursoRRepository {

    Curso getCurso(UUID ui_id_curso);
    List<Curso> getCursos();
}