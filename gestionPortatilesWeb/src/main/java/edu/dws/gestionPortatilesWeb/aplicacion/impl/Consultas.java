package edu.dws.gestionPortatilesWeb.aplicacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.AlumnosRepo;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.PortatilesRepo;

@Service(value="Consultas")
public class Consultas {

	@Autowired
	private AlumnosRepo alm;
	@Autowired
	private PortatilesRepo prt;
	
	@Transactional
	public void insertarUnAlumno(Alumnos alumno) {
		alm.save(alumno);
	}
	
	@Transactional
	public void insertarUnPortatil(Portatiles portatil) {
		prt.save(portatil);
	}
	
	
}
