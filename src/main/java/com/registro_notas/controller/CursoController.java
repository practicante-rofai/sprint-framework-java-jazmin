package com.registro_notas.controller;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registro_notas.domain.Curso;
import com.registro_notas.service.read.CursoRService;
import com.registro_notas.service.write.CursoWService;

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

@CrossOrigin(origins = "*")
@Component
@RequestMapping("/registro_notas")
public class CursoController {

    @Autowired
    private CursoRService cursoRService;

    @Autowired
    private CursoWService cursoWService;

    private static final Logger logger = LoggerFactory.getLogger(CursoController.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/curso/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Curso getCurso(@PathVariable("id") UUID idCurso) {
		logger.info("Controller - getCurso(UUID ui_id_curso)");
		logger.info("Input");
		logger.info("idCurso: " + idCurso);
		Curso curso = new Curso();
		curso = cursoRService.getCurso(idCurso);
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(curso));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return curso;
    }
    
    @RequestMapping(value = "/curso", method = RequestMethod.GET)
	@ResponseBody
	public List<Curso> getCursos() {
		logger.info("Controller - getCursos()");
		logger.info("Input");
		List<Curso> listCursos = null;
		listCursos = cursoRService.getCursos();
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(listCursos));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return listCursos;
    }
    
    @RequestMapping(value = "/curso", method = RequestMethod.POST)
	@ResponseBody
	public UUID createCurso(@RequestBody String payload) {
		logger.info("Controller - getCursos()");
		logger.info("Input");
		logger.info("payload: ", payload);
		ObjectMapper objectMapper = new ObjectMapper();
		Curso curso = new Curso();
		try {
			curso = objectMapper.readValue(payload, Curso.class);
			logger.info("Output");
			return cursoWService.createCurso(curso);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			logger.info("Output");
			return null;
		}
	}


	@RequestMapping(value = "/curso", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updateCurso(@RequestBody String payload) {
		ObjectMapper objectMapper = new ObjectMapper();
		Curso curso = new Curso();
		try {
			curso = objectMapper.readValue(payload, Curso.class);
			return cursoWService.updateCurso(curso);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			return false;
		}
	}

	@RequestMapping(value = "/curso/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteCurso(@PathVariable("id") UUID idCurso) {
		logger.info("Controller - getCurso(UUID id_curso)");
		logger.info("Input");
		logger.info("idCurso: " + idCurso);
		logger.info("Output");
		
		try {
			return cursoWService.deleteCurso(idCurso);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			return false;
		}
	}
}
