package com.registro_notas.service.write;

import java.util.UUID;

import com.registro_notas.domain.Curso;

public interface CursoWService {

    UUID createCurso(Curso curso);

    boolean updateCurso(Curso curso);

    boolean deleteCurso(UUID ui_id_curso);
}