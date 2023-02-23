package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;

public class ADtoServicioImpl implements ADtoServicio {

	@Override
	public AlumnosDTO AAlumnosDTO(String md_uuid, Calendar md_date, String nombre_alumno, String apellidos_alumno,
			String num_telefono, Portatiles portatil) {
		AlumnosDTO alumnoDTO = new AlumnosDTO(md_uuid, md_date, nombre_alumno, apellidos_alumno, num_telefono, portatil);

		return alumnoDTO;
	}

	@Override
	public PortatilesDTO APortatilesDTO(String modelo, String marca) {
		PortatilesDTO portatilDTO = new PortatilesDTO( modelo, marca);
		return portatilDTO;
	}

	
	@Override
	public List<AlumnosDTO> AListaAlumnosDTO(List<Alumnos> listaAlumnos) {
		List<AlumnosDTO> listaAlumnosDTO=new ArrayList<AlumnosDTO>();
		for(Alumnos alumno:listaAlumnos) {
			AlumnosDTO alumnoDTO = new AlumnosDTO(alumno.getId_alumno(), alumno.getMd_uuid(), alumno.getMd_date(), alumno.getNombre(), alumno.getApellidos(), alumno.getNum_telefono(), alumno.getPortatiles());
			listaAlumnosDTO.add(alumnoDTO);
		}
		return listaAlumnosDTO;
	}

	@Override
	public AlumnosDTO FormAlumnoAAlumnoDTO(FormAlmDTO alumnoV, Portatiles portatil) {
		AlumnosDTO alumnoDTO=new AlumnosDTO(alumnoV.getMd_uuid(), alumnoV.getMd_date(),alumnoV.getNombre(), alumnoV.getApellidos(), alumnoV.getNum_telefono(), portatil);
		return alumnoDTO;
	}

}
