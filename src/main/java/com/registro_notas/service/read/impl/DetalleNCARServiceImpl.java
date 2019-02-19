package com.registro_notas.service.read.impl;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.DetalleNCA;
import com.registro_notas.repository.read.DetalleNCARRepository;
import com.registro_notas.service.read.DetalleNCARService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleNCARServiceImpl implements DetalleNCARService {

    @Autowired
    private DetalleNCARRepository detalleNCARRepository;

    @Override
    public DetalleNCA getDetalleNCA(UUID ui_id_nota) {
        return detalleNCARRepository.getDetalleNCA(ui_id_nota);
    }

    @Override
    public List<DetalleNCA> getDetallesNCA() {
        return detalleNCARRepository.getDetallesNCA();
    }

    
}