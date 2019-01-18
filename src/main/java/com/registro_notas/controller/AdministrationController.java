package com.registro_notas.controller;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registro_notas.domain.Alumno;
import com.registro_notas.service.read.AlumnoRService;

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
@RequestMapping("/administration")
public class AdministrationController {

    @Autowired
    private AlumnoRService alumnoRService;

    private static final Logger logger = LoggerFactory.getLogger(AdministrationController.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/alumno/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Alumno getAlumno(@PathVariable("id") UUID idAlumno) {
		logger.info("Controller - getAlumno(UUID ui_idalumno)");
		logger.info("Input");
		logger.info("idAlumno: " + idAlumno);
		Alumno alummo = new Alumno();
		alummo = alumnoRService.getAlumno(idAlumno);
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(alummo));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return alummo;
	}

	@RequestMapping(value = "/alumno", method = RequestMethod.GET)
	@ResponseBody
	public List<Alumno> getAlumnos() {
		logger.info("Controller - getAlumnos()");
		logger.info("Input");
		List<Alumno> listAlumnos = null;
		listAlumnos = alumnoRService.getAlumnos();
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(listAlumnos));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return listAlumnos;
	}
}