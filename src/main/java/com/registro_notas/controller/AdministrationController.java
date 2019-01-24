package com.registro_notas.controller;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registro_notas.domain.Alumno;
import com.registro_notas.service.read.AlumnoRService;
import com.registro_notas.service.write.AlumnoWService;

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

@CrossOrigin(origins="*")
@Component
@RequestMapping("/registro_notas")
public class AdministrationController {

    @Autowired
	private AlumnoRService alumnoRService;
	
	@Autowired
	private AlumnoWService alumnoWService;

    private static final Logger logger = LoggerFactory.getLogger(AdministrationController.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/alumno/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Alumno getAlumno(@PathVariable("id") UUID idAlumno) {
		logger.info("Controller - getAlumno(UUID id_alumno)");
		logger.info("Input");
		logger.info("idAlumno: " + idAlumno);
		Alumno alumno = new Alumno();
		alumno = alumnoRService.getAlumno(idAlumno);
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(alumno));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return alumno;
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

	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	@ResponseBody
	public UUID createAlumno(@RequestBody String payload) {
		logger.info("Controller - getAlumnos()");
		logger.info("Input");
		logger.info("payload: ", payload);
		ObjectMapper objectMapper = new ObjectMapper();
		Alumno alumno = new Alumno();
		try {
			alumno = objectMapper.readValue(payload, Alumno.class);
			logger.info("Output");
			return alumnoWService.createAlumno(alumno);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			logger.info("Output");
			return null;
		}
	}


	@RequestMapping(value = "/alumno", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updateAlumno(@RequestBody String payload) {
		ObjectMapper objectMapper = new ObjectMapper();
		Alumno alumno = new Alumno();
		try {
			alumno = objectMapper.readValue(payload, Alumno.class);
			return alumnoWService.updateAlumno(alumno);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			return false;
		}
	}

	@RequestMapping(value = "/alumno/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteAlumno(@PathVariable("id") UUID idAlumno) {
		logger.info("Controller - getAlumno(UUID id_alumno)");
		logger.info("Input");
		logger.info("idAlumno: " + idAlumno);
		logger.info("Output");
		
		try {
			
			return alumnoWService.deleteAlumno(idAlumno);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			return false;
		}
	}
}