package com.registro_notas.controller;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registro_notas.domain.Nota;
import com.registro_notas.service.read.NotaRService;
import com.registro_notas.service.write.NotaWService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins ="*")
@Component
@RequestMapping("/registro_notas")

public class NotaController {

    @Autowired
	private NotaRService notaRService;
	
	@Autowired
    private NotaWService notaWService;
    
    private static final Logger logger = LoggerFactory.getLogger(NotaController.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/notas/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Nota getNota(@PathVariable("id") UUID idNota) {
		logger.info("Controller - getNota(UUID ui_id_nota)");
		logger.info("Input");
		logger.info("idNota: " + idNota);
		Nota nota = new Nota();
		nota = notaRService.getNota(idNota);
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(nota));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return nota;
	}

	@RequestMapping(value = "/notas", method = RequestMethod.GET)
	@ResponseBody
	public List<Nota> getNotas() {
		logger.info("Controller - getNotas()");
		logger.info("Input");
		List<Nota> listNotas = null;
		listNotas = notaRService.getNotas();
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(listNotas));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return listNotas;
	}

	@RequestMapping(value = "/notas", method = RequestMethod.POST)
	@ResponseBody
	public UUID createNota(@RequestBody String payload) {
		logger.info("Controller - getAlumnos()");
		logger.info("Input");
		logger.info("payload: ", payload);
		ObjectMapper objectMapper = new ObjectMapper();
		Nota nota = new Nota();
		try {
			nota = objectMapper.readValue(payload, Nota.class);
			logger.info("Output");
			return notaWService.createNota(nota);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			logger.info("Output");
			return null;
		}
	}
}