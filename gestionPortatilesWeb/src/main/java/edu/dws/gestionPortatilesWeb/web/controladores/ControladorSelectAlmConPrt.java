package edu.dws.gestionPortatilesWeb.web.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADaoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADtoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADtoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AdaoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AlumnosDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.ConsultasImpl;

@Controller
public class ControladorSelectAlmConPrt {

	//Declaramos todo lo que vamos a usar.
	@Autowired
	Consultas consulta = new ConsultasImpl();
	List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();

	@RequestMapping(value = "/selectAlmConPrt")//Como vamos a llamar a la vista de selectAlmConPrt en nuestro index
	public ModelAndView gestionSolicitud() {

		try {
			//Creamos una lista con todos los alumnos a traves de la siguiente consulta
			listaAlumnos = consulta.getTodosAlumnos();

			//Convertimos la lista a dto
			listaAlumnosDTO = aDto.AListaAlumnosDTO(listaAlumnos);

			//Añadimos al map la lista de alumnos dto
			miModelo.put("listaAlumnosDTO", listaAlumnosDTO);

		} catch (Exception e) {
			System.out.println(e);
		}

		//Devolvemos la vista y le pasamos el map
		return new ModelAndView("selectAlmConPrt", "miModelo", miModelo);
	}

}
