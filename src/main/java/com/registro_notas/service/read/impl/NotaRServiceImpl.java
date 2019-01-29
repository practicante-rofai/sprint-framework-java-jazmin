package com.registro_notas.service.read.impl;

import java.util.List;
import java.util.UUID;

import com.registro_notas.domain.Nota;
import com.registro_notas.repository.read.NotaRRepository;
import com.registro_notas.service.read.NotaRService;

import org.springframework.beans.factory.annotation.Autowired;

public class NotaRServiceImpl implements NotaRService {

    @Autowired
    private NotaRRepository notaRRepository;

    @Override
    public Nota getNota(UUID ui_id_nota) {
        return notaRRepository.getNota(ui_id_nota);
    }

    @Override
    public List<Nota> getNotas() {
        return notaRRepository.getNotas();
    }

}