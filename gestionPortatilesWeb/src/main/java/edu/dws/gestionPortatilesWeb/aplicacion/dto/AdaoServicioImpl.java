package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Usuario;


public class AdaoServicioImpl implements ADaoServicio {

	// Convertimos un alumno dto en alumno dao
	@Override
	public Alumnos AlumnosDTOADAO(AlumnosDTO alumnoDTO) {
		Alumnos alumno = new Alumnos();
		if (alumnoDTO != null) {
			alumno.setId_alumno(alumnoDTO.getId_alumno());
			alumno.setMd_uuid(alumnoDTO.getMd_uuid());
			alumno.setMd_date(alumnoDTO.getMd_date());
			alumno.setNombre(alumnoDTO.getNombre());
			alumno.setApellidos(alumnoDTO.getApellidos());
			alumno.setNum_telefono(alumnoDTO.getNum_telefono());
			alumno.setPortatiles(alumnoDTO.getPortatiles());
		}
		return alumno;
	}

	// Convertimos un portatil dto en portatil dao
	@Override
	public Portatiles PortatilesDTOADAO(PortatilesDTO portatilDTO) {
		Portatiles portatil = new Portatiles();
		if (portatilDTO != null) {
			portatil.setMd_uuid(portatilDTO.getMd_uuid());
			portatil.setMd_date(portatilDTO.getMd_date());
			portatil.setMarca(portatilDTO.getMarca());
			portatil.setModelo(portatilDTO.getModelo());
			portatil.setAlumno(portatilDTO.getAlumno());
		}
		return portatil;
	}

	@Override
	public Usuario UsuarioDTOADAO(UsuarioDTO usuarioDTO) {
		Usuario usuario=new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setRole(usuarioDTO.getRole());
		return usuario;
	}

	

}
