package com.registro_notas.service.read;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Nota;

public interface NotaRService {

    Nota getNota(UUID ui_id_nota);
    List<Nota> getNotas();
}