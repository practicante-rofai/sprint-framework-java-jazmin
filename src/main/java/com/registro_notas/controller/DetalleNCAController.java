package com.registro_notas.controller;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registro_notas.domain.DetalleNCA;
import com.registro_notas.service.read.DetalleNCARService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins="*")
@Component
@RequestMapping("/registro_notas_detalle")
public class DetalleNCAController {

    @Autowired
    private DetalleNCARService detalleNCARService;

    private static final Logger logger = LoggerFactory.getLogger(DetalleNCAController.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    
    @RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	@ResponseBody
	public DetalleNCA getDetalleNCA(@PathVariable("id") UUID idNota) {
		logger.info("Controller - getDetalleNCA(UUID ui_id_nota)");
		logger.info("Input");
		logger.info("idCurso: " + idNota);
		DetalleNCA detalle_nca = new DetalleNCA();
		detalle_nca = detalleNCARService.getDetalleNCA(idNota);
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(detalle_nca));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return detalle_nca;
	}

	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	@ResponseBody
	public List<DetalleNCA> getDetallesNCA() {
		logger.info("Controller - getDetallesNCA()");
		logger.info("Input");
		List<DetalleNCA> listDetallesNCA = null;
		listDetallesNCA = detalleNCARService.getDetallesNCA();
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(listDetallesNCA));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return listDetallesNCA;
    }
}