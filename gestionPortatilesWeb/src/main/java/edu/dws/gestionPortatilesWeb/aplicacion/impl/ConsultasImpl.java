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
public class ConsultasImpl implements Consultas{

	@Autowired
	private AlumnosRepo alm;
	@Autowired
	private PortatilesRepo prt;
	
	//Consultas para alumnos
	//Insert de alumnos	
	@Override
	public void insertarUnAlumno(Alumnos alumno) {
		alm.save(alumno);		
	}
	//Select todos los alumnos
	@Override
	public List<Alumnos> getTodosAlumnos(){
		return (List<Alumnos>) alm.findAll();
	}
	//Delete alumno
	@Override
	public void borrarAlumno(int id) {
		alm.deleteById(id);
	}
	//Select un alumno
	@Override
	public Alumnos selectUnAlumno(Integer idAlumno) {
		Alumnos alumno=alm.findById(idAlumno).orElse(null);
		return alumno;
	}
	
	//Consultas para los portatiles
	//Insert portatil
	@Override
	public void insertarUnPortatil(Portatiles portatil) {
		prt.save(portatil);
	}
	//Select un portatil
	@Override
	public Portatiles selectUnPortatil(Integer idPortatil) {
		Portatiles portatil=prt.findById(idPortatil).orElse(null);
		return portatil;
	}
	//Select todos los portatiles
	@Override
	public List<Portatiles> getTodosPortatiles(){
		return (List<Portatiles>) prt.findAll();
	}
	
	
	
	
}
