package edu.dws.gestionPortatilesWeb.aplicacion.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;

public class ADtoServicioImpl implements ADtoServicio {

	//Convertimos un alumno dao en dto
	@Override
	public AlumnosDTO AAlumnosDTO(Integer id_alumno,String md_uuid, Calendar md_date, String nombre_alumno, String apellidos_alumno,
			String num_telefono, Portatiles portatil) {
		AlumnosDTO alumnoDTO = new AlumnosDTO(id_alumno,md_uuid, md_date, nombre_alumno, apellidos_alumno, num_telefono, portatil);

		return alumnoDTO;
	}

	//Convertimos un portatil dao en dto
	@Override
	public PortatilesDTO APortatilesDTO(String modelo, String marca) {
		PortatilesDTO portatilDTO = new PortatilesDTO( marca, modelo);
		return portatilDTO;
	}

	//Convertimos un portatil dao en dto 2
	@Override
	public PortatilesDTO APortatilesDTO(String md_uuid, Calendar md_date,String modelo, String marca, Alumnos alumno) {
		PortatilesDTO portatilDTO = new PortatilesDTO( md_uuid,  md_date,marca ,  modelo,  alumno);
		return portatilDTO;
	}
	
	//Convertimos una lista de portatiles dao en dto
	@Override
	public List<PortatilesDTO> AListaPortatilesDTO(List<Portatiles> listaPortatiles) {
		List<PortatilesDTO> listaPortatilesDTO=new ArrayList<PortatilesDTO>();
		for(Portatiles portatil:listaPortatiles) {
			PortatilesDTO portatilDTO = new PortatilesDTO(portatil.getId_ordenador(), portatil.getMd_uuid(), portatil.getMd_date(), portatil.getMarca(), portatil.getModelo(), portatil.getAlumno());
			listaPortatilesDTO.add(portatilDTO);
		}
		return listaPortatilesDTO;
	}

	//Convertimos una lista de alumnos dao en dto
	@Override
	public List<AlumnosDTO> AListaAlumnosDTO(List<Alumnos> listaAlumnos) {
		List<AlumnosDTO> listaAlumnosDTO=new ArrayList<AlumnosDTO>();
		for(Alumnos alumno:listaAlumnos) {
			AlumnosDTO alumnoDTO = new AlumnosDTO(alumno.getId_alumno(), alumno.getMd_uuid(), alumno.getMd_date(), alumno.getNombre(), alumno.getApellidos(), alumno.getNum_telefono(), alumno.getPortatiles());
			listaAlumnosDTO.add(alumnoDTO);
		}
		return listaAlumnosDTO;
	}

	//Convertimos los datos recogidos del formulario a un alumno DTO
	@Override
	public AlumnosDTO FormAlumnoAAlumnoDTO(FormAlmDTO alumnoV, Portatiles portatil) {
		AlumnosDTO alumnoDTO=new AlumnosDTO(alumnoV.getMd_uuid(), alumnoV.getMd_date(),alumnoV.getNombre(), alumnoV.getApellidos(), alumnoV.getNum_telefono(), portatil);
		return alumnoDTO;
	}

	@Override
	public UsuarioDTO AUsuarioDAO(String username, String email, String password, Integer rol) {
		UsuarioDTO usuarioDTO=new UsuarioDTO(username,email,password,rol);
		return usuarioDTO;
	}

}
