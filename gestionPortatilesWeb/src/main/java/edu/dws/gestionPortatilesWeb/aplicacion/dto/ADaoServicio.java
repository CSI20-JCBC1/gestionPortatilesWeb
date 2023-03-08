package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Usuario;


public interface ADaoServicio {

	public Alumnos AlumnosDTOADAO(AlumnosDTO alumnoDTO);

	public Portatiles PortatilesDTOADAO(PortatilesDTO portatileDTO);
	
	public Usuario UsuarioDTOADAO(UsuarioDTO usuarioDTO);
	
	

}
