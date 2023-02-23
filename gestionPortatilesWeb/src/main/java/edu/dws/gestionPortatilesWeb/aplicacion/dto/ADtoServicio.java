package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import java.util.Calendar;
import java.util.List;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;

public interface ADtoServicio {
	
	public AlumnosDTO AAlumnosDTO(String md_uuid, Calendar md_date, String nombre_alumno,
			String apellidos_alumno, String num_telefono, Portatiles portatil);
	
	public PortatilesDTO APortatilesDTO(String modelo, String marca);
	
	public List<AlumnosDTO> AListaAlumnosDTO(List<Alumnos> listaAlumnos);
	
	public AlumnosDTO FormAlumnoAAlumnoDTO(FormAlmDTO alumnoV, Portatiles portatil);


}
