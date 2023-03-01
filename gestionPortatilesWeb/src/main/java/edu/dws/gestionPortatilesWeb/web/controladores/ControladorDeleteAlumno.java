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
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADaoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADtoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADtoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AdaoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AlumnosDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.ConsultasImpl;

@Controller
public class ControladorDeleteAlumno {

	//Declaramos todo lo que vamos a usar.
	@Autowired
	Consultas consulta = new ConsultasImpl();
	List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/borrarAlumno")//Como vamos a llamar a la vista de borrarAlumno en nuestro index
	public ModelAndView navegacionFormulario(Model modelo) {

		try {
			//Creamos una lista de alumnos con todos los alumnos que hay
			listaAlumnos = consulta.getTodosAlumnos();
			//Convertimos la lista en alumnos dto para pasarlo a la vista
			listaAlumnosDTO = aDto.AListaAlumnosDTO(listaAlumnos);
			//Añadimos la lista al map
			miModelo.put("listaAlumnosDTO", listaAlumnosDTO);
			//Creamos un alumno DTO que rellenaremos en la vista con un formulario y se lo pasamos a la vista
			AlumnosDTO alumnoDTO = new AlumnosDTO();
			modelo.addAttribute("alumnoV", alumnoDTO);
		} catch (Exception e) {
			System.out.println(e);
		}
		//Devolvemos la vista y le pasamos el map
		return new ModelAndView("borrarAlumno", "miModelo", miModelo);
	}

	@RequestMapping(value = "/borrarAlum", method = RequestMethod.POST)//Donde va a buscar la vista al enviar el formulario en la propiedad action.
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoV") AlumnosDTO alumnoV) {

		try {
			//Si el id del alumno devuelto por la vista es distinto de null
			if (alumnoV.getId_alumno()!=null) {
				//Convertimos el dto a dao
				aDao.AlumnosDTOADAO(alumnoV);
				//Realizamos una consulta a la base de datos para borrar el alumno por id
				consulta.borrarAlumno(alumnoV.getId_alumno());
				//Metemos en el map un mensaje de que el alumno está borrado para devolverlo a la vista
				miModelo.put("mensaje", "Alumno Borrado");
				//Pasamos la lista nueva a la vista con el map sin el alumno que acabamos de borrar
				listaAlumnos = consulta.getTodosAlumnos();
				listaAlumnosDTO = aDto.AListaAlumnosDTO(listaAlumnos);
				miModelo.put("listaAlumnosDTO", listaAlumnosDTO);
			}
			else {
				//Si es null mandamos el siguiente mensaje.
				miModelo.put("mensaje", "No existe ningún alumno");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		//Devolvemos a la vista el map para así mostrar la nueva lista sin el alumno borrado
		return new ModelAndView("borrarAlumno", "miModelo", miModelo);
	}

}
