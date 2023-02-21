package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;

public interface ADaoServicio {
	
	public Alumnos AlumnosDTOADAO(AlumnosDTO alumnoDTO);

	public Portatiles PortatilesDTOADAO(PortatilesDTO portatileDTO);
	

}
