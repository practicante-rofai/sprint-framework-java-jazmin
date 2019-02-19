package com.registro_notas.repository.read;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.DetalleNCA;

public interface DetalleNCARRepository {

    DetalleNCA getDetalleNCA(UUID ui_id_nota);
    List <DetalleNCA> getDetallesNCA();
}