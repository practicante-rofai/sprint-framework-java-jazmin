package com.registro_notas.service.write.impl;

import java.util.UUID;

import com.registro_notas.domain.Nota;
import com.registro_notas.repository.write.NotaWRepository;
import com.registro_notas.service.write.NotaWService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaWServiceImpl implements NotaWService {

    @Autowired
    private NotaWRepository notaWRepository;

    @Override
    public UUID createNota(Nota nota) {
        return notaWRepository.createNota(nota);
    }

    
}