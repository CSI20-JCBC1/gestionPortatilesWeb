package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;

public class AdaoServicioImpl implements ADaoServicio {

	@Override
	public Alumnos AlumnosDTOADAO(AlumnosDTO alumnoDTO) {
		Alumnos alumno=new Alumnos();
		if(alumnoDTO != null) {
			alumno.setMd_uuid(alumnoDTO.getMd_uuid());
			alumno.setMd_date(alumnoDTO.getMd_date());
			alumno.setNombre(alumnoDTO.getNombre());
			alumno.setApellidos(alumnoDTO.getApellidos());
			alumno.setNum_telefono(alumnoDTO.getNum_telefono());
			alumno.setPortatiles(alumnoDTO.getPortatiles());
		}
		return alumno;
	}

	@Override
	public Portatiles PortatilesDTOADAO(PortatilesDTO portatilDTO) {
		Portatiles portatil = new Portatiles();
		if(portatilDTO != null) {
			portatil.setMd_uuid(portatilDTO.getMd_uuid());
			portatil.setMd_date(portatilDTO.getMd_date());
			portatil.setMarca(portatilDTO.getMarca());;
			portatil.setModelo(portatilDTO.getModelo());
			portatil.setAlumno(portatilDTO.getAlumno());
		}
		return portatil;
	}

}
