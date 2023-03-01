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
public class ControladorAlumnoPorIdPortatil {

	//Declaramos todo lo que vamos a usar
	@Autowired
	Consultas consulta = new ConsultasImpl();

	List<Portatiles> listaPortatiles = new ArrayList<Portatiles>();
	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	List<PortatilesDTO> listaPortatilesDTO = new ArrayList<PortatilesDTO>();
	Alumnos alumno = new Alumnos();
	PortatilesDTO portatilDTO = new PortatilesDTO();
	Portatiles portatil = new Portatiles();

	protected final Log logger = LogFactory.getLog(getClass());
	
	
	@RequestMapping(value = "/navegacionFormularioAlumnoPorIdPortatil")//Como vamos a llamar a la vista de selectAlmPorIdPrt en nuestro index
	public ModelAndView navegacionFormulario(Model modelo) {
		try {
			//Creamos una lista de portatiles y llamamos a la consulta que devuelve la lista de portatiles
			listaPortatiles = consulta.getTodosPortatiles();
			//Convertimos la lista a una lista de portatiles DTO
			listaPortatilesDTO = aDto.AListaPortatilesDTO(listaPortatiles);
			//Creamos una lista de portatiles auxiliar y llenamos la lista con los portatiles que esten asignados a un alumno
			List<PortatilesDTO> listaPortatilesDTO2 = new ArrayList<PortatilesDTO>();
			for (PortatilesDTO prt : listaPortatilesDTO) {
				if (prt.getAlumno() != null)
					listaPortatilesDTO2.add(prt);

			}
			//Pasamos la lista a la vista
			miModelo.put("listaPortatilesDTO2", listaPortatilesDTO2);
			//Creamos un portatil DTO que rellenaremos en la vista con un formulario y se lo pasamos a la vista
			PortatilesDTO portatilDTO = new PortatilesDTO();
			modelo.addAttribute("portatilV", portatilDTO);

		} catch (Exception e) {
			System.out.println(e);
		}
		//Devolvemos la vista y le pasamos el map
		return new ModelAndView("selectAlmPorIdPrt", "miModelo", miModelo);

	}

	
	@RequestMapping(value = "/buscarAlumno", method = RequestMethod.POST)//Donde va a buscar la vista al enviar el formulario en la propiedad action.
	public ModelAndView guardarAlumno(@ModelAttribute("portatilV") PortatilesDTO portatilV) {

		try {
			//Si no hay portatiles asignados a un alumno mostramos el siguiente mensaje
			if(portatilV.getId_ordenador()==null) {
				miModelo.put("mensaje", "No hay alumnos que mostrar, pues no existe ningun portatil asignado a un alumno.");
			}
			else {
			//Si los hay hacemos una consulta para seleccionar el portatil
			portatil = consulta.selectUnPortatil(portatilV.getId_ordenador());

			//Creamos una consulta de alumno donde buscamos el alumno a través de su portatil asignado de la siguiente manera
			alumno = consulta.selectUnAlumno(portatil.getAlumno().getId_alumno());

			//Convertimos el alumno dao a dto para así pasar el alumno a la vista.
			AlumnosDTO alumnoDTO = aDto.AAlumnosDTO(alumno.getId_alumno(), alumno.getMd_uuid(), alumno.getMd_date(),
					alumno.getNombre(), alumno.getApellidos(), alumno.getNum_telefono(), alumno.getPortatiles());

			//Metemos en el map el alumno.
			miModelo.put("mensaje", alumnoDTO.toString());}

		} catch (Exception e) {
			System.out.println(e);
		}
		//Devolvemos a la vista el map para así mostrar el alumno asignado a este portatil
		return new ModelAndView("selectAlmPorIdPrt", "miModelo", miModelo);
	}

}
