package com.registro_notas.service.write;

import java.util.UUID;

import com.registro_notas.domain.Nota;

public interface NotaWService {

    UUID createNota(Nota nota);
}