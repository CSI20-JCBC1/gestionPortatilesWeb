package edu.dws.gestionPortatilesWeb.aplicacion.impl;

import java.util.List;

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
	
	@Transactional
	public Portatiles selectUnPortatil(Integer idPortatil) {
		Portatiles portatil=prt.findById(idPortatil).orElse(null);
		return portatil;
	}
	
	@Transactional
	public List<Alumnos> getTodosAlumnos(){
		return (List<Alumnos>) alm.findAll();
	}
	
	
}
