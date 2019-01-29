package com.registro_notas.repository.write;

import java.util.UUID;

import com.registro_notas.domain.Nota;

public interface NotaWRepository {

    UUID createNota(Nota nota);
}