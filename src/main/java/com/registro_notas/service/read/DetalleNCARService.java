package com.registro_notas.service.read;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.DetalleNCA;

public interface DetalleNCARService {

    DetalleNCA getDetalleNCA(UUID ui_id_nota);
    List <DetalleNCA> getDetallesNCA();
}