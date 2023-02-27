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
import edu.dws.gestionPortatilesWeb.aplicacion.dto.FormAlmDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.PortatilesDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;

@Controller
public class ControladorDeleteAlumno {

	@Autowired
	Consultas consulta = new Consultas();
	List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/borrarAlumno")
	public ModelAndView navegacionFormulario(Model modelo) {

		try {
			listaAlumnos = consulta.getTodosAlumnos();
			listaAlumnosDTO = aDto.AListaAlumnosDTO(listaAlumnos);
			miModelo.put("listaAlumnosDTO", listaAlumnosDTO);
			AlumnosDTO alumnoDTO = new AlumnosDTO();
			modelo.addAttribute("alumnoV", alumnoDTO);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("borrarAlumno", "miModelo", miModelo);
	}

	@RequestMapping(value = "/borrarAlum", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoV") AlumnosDTO alumnoV) {

		try {
			if (alumnoV.getId_alumno()!=null) {
				aDao.AlumnosDTOADAO(alumnoV);

				consulta.borrarAlumno(alumnoV.getId_alumno());

				miModelo.put("mensaje", "Alumno Borrado");

				listaAlumnos = consulta.getTodosAlumnos();
				listaAlumnosDTO = aDto.AListaAlumnosDTO(listaAlumnos);
				miModelo.put("listaAlumnosDTO", listaAlumnosDTO);
			}
			else {
				miModelo.put("mensaje", "El id no puede ser null");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ModelAndView("borrarAlumno", "miModelo", miModelo);
	}

}
