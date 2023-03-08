package edu.dws.gestionPortatilesWeb.aplicacion.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Usuario;

public interface Consultas {
	
	
	@Transactional
	public void insertarUnAlumno(Alumnos alumno);
	//Select todos los alumnos
	@Transactional
	public List<Alumnos> getTodosAlumnos();	
	//Delete alumno
	@Transactional
	public void borrarAlumno(int id);
	//Select un alumno
	@Transactional
	public Alumnos selectUnAlumno(Integer idAlumno);
	
	//Consultas para los portatiles
	//Insert portatil
	@Transactional
	public void insertarUnPortatil(Portatiles portatil);
	//Select un portatil
	@Transactional
	public Portatiles selectUnPortatil(Integer idPortatil);
	//Select todos los portatiles
	@Transactional
	public List<Portatiles> getTodosPortatiles();
	
	//Consultas usuario
	public Usuario selectUnUsuario(Integer id);
	public void insertarUnUsuario(Usuario usuario);
}
