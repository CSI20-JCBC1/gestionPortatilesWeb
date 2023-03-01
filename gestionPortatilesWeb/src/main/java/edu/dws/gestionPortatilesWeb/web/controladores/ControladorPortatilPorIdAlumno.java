package edu.dws.gestionPortatilesWeb.web.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Alumnos;
import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADaoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADtoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADtoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AdaoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AlumnosDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.PortatilesDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.ConsultasImpl;

@Controller
public class ControladorPortatilPorIdAlumno {

	//Declaramos todo lo que vamos a utilizar
	@Autowired
	Consultas consulta = new ConsultasImpl();

	List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();
	Portatiles portatil = new Portatiles();
	AlumnosDTO alumnoDTO = new AlumnosDTO();
	Alumnos alumno = new Alumnos();

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/navegacionFormularioPortatilPorIdAlumno")//Como vamos a llamar a la vista de selectPrtPorIdAlm en nuestro index
	public ModelAndView navegacionFormulario(Model modelo) {
		try {
			//Creamos una lista de alumnos a través de la siguiente consulta
			listaAlumnos = consulta.getTodosAlumnos();
			//Convertimos a DTO
			listaAlumnosDTO = aDto.AListaAlumnosDTO(listaAlumnos);
			//Metemos la lista en un map
			miModelo.put("listaAlumnosDTO", listaAlumnosDTO);
			//Creamos un alumno DTO para recoger los datos del form y se lo pasamos a la vista
			AlumnosDTO alumnoDTO = new AlumnosDTO();
			modelo.addAttribute("alumnoV", alumnoDTO);
		} catch (Exception e) {
			System.out.println(e);
		}

		//Devolvemos la vista y le pasamos el map
		return new ModelAndView("selectPrtPorIdAlm", "miModelo", miModelo);

	}

	@RequestMapping(value = "/buscarPortatil", method = RequestMethod.POST)//Donde va a buscar la vista al enviar el formulario en la propiedad action.
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoV") AlumnosDTO alumnoV) {

		try {
			//Si no existen alumnos en la base de datos
			if (alumnoV.getId_alumno() == null) {
				miModelo.put("mensaje", "No hay portatiles que mostrar, pues no existen alumnos.");

			} else {
				//Si existen creamos una consulta donde creamos un alumno a partir del id recogido de la vista.
				alumno = consulta.selectUnAlumno(alumnoV.getId_alumno());

				//Creamos un portatil con la siguiente consulta, a través del id del ordenador que pertenece a este alumno
				portatil = consulta.selectUnPortatil(alumno.getPortatiles().getId_ordenador());
				//Pasamos de dao a dto
				PortatilesDTO portatilDTO = aDto.APortatilesDTO(portatil.getMd_uuid(), portatil.getMd_date(),
						portatil.getMarca(), portatil.getModelo(), portatil.getAlumno());

				//Si no tiene portatil, nos saldra que no hay portatiles que mostrar
				if (portatilDTO == null)
					miModelo.put("mensaje", "No hay portatiles que mostrar");
				else
					//Si no es null nos mostrará el siguiente mensaje
					miModelo.put("mensaje", portatilDTO.toString());
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		//Devolvemos la vista y le pasamos el map para que muestre el mensaje
		return new ModelAndView("selectPrtPorIdAlm", "miModelo", miModelo);
	}

}
