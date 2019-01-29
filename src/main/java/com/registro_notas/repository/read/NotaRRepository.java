package com.registro_notas.repository.read;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Nota;

public interface NotaRRepository {

    Nota getNota(UUID ui_id_nota);
    List<Nota> getNotas();
}