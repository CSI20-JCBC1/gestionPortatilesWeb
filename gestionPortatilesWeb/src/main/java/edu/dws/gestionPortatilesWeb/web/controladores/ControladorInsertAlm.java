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
import edu.dws.gestionPortatilesWeb.aplicacion.dto.FormAlmDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.PortatilesDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.ConsultasImpl;

@Controller
public class ControladorInsertAlm {
	//Declaramos todo lo que vamos a usar.
	@Autowired
	Consultas consulta = new ConsultasImpl();

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	Portatiles portatil = new Portatiles();
	AlumnosDTO alumnoDTO = new AlumnosDTO();
	Alumnos alumno = new Alumnos();
	List<PortatilesDTO> listaPortatilesDTO = new ArrayList<PortatilesDTO>();
	List<Portatiles> listaPortatiles = new ArrayList<Portatiles>();

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/navegacionFormularioAlm")//Como vamos a llamar a la vista de formularioInsertAlm en nuestro index
	public ModelAndView navegacionFormulario(Model modelo) {
		try {
			logger.info("Navegamos al formulario");
			//Creamos un dto para recoger los datos del alumno del form
			FormAlmDTO alumnoForm = new FormAlmDTO();
			//Con la consulta llenamos la lista de alumnos con todos los alumnos
			listaPortatiles = consulta.getTodosPortatiles();
			//Pasamos la lista de dao a dto
			listaPortatilesDTO = aDto.AListaPortatilesDTO(listaPortatiles);
			//Creamos una lista auxiliar para llenarla con los portatiles que no esten asignados a ningun alumno
			List<PortatilesDTO> listaPortatilesDTO2 = new ArrayList<PortatilesDTO>();
			for (PortatilesDTO prt : listaPortatilesDTO) {
				if (prt.getAlumno() == null)
					listaPortatilesDTO2.add(prt);
			}
			//Le pasamos la lista a la vista a través de un map
			miModelo.put("listaPortatilesDTO2", listaPortatilesDTO2);
			//Le pasamos a la vista el dto para recoger los datos del form
			modelo.addAttribute("alumnoV", alumnoForm);

		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Devolvemos la vista y le pasamos el map
		return new ModelAndView("formularioInsertAlm", "miModelo", miModelo);
	}

	@RequestMapping(value = "/guardarAlumno", method = RequestMethod.POST)//Donde va a buscar la vista al enviar el formulario en la propiedad action.
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoV") FormAlmDTO alumnoV) {

		try {
			//Comprobamos si los datos del form son nulos, si alguno de ellos es nulo mandamos el mensaje siguiente
			if (alumnoV.getIdPortatil() == null||alumnoV.getNombre().isEmpty()||alumnoV.getApellidos().isEmpty()||alumnoV.getNum_telefono().isEmpty()) {

				miModelo.put("mensaje", "Ningún campo puede ser nulo");
				
			} else {
				//Si no son nulos
				//Creamos una lista de alumnos con todos los alumnos a traves de la consulta
				List<Alumnos> listaAlumnos = consulta.getTodosAlumnos();
				//A continuación comprobamos si dos portatiles tienen el mismmo id, recorremos la lista y si lo tienen,
				//Inicializamos a true la variable repetido y salimos del bucle
				Boolean repetido = false;
				for (Alumnos alm : listaAlumnos) {
					if (alm.getPortatiles().getId_ordenador() == alumnoV.getIdPortatil()) {
						repetido = true;
						break;
					}
				}
				//Si el id de portatil no se repite
				if (!repetido) {
					
					//Creamos un portatil a traves de la siguiente consulta con los datos recogidos del formulario 
					portatil = consulta.selectUnPortatil(alumnoV.getIdPortatil());
					//Convertimos los datos del formulario en un alumno dto pasandole el dto del form, 
					//y el portatil que hemos construido antes
					alumnoDTO = aDto.FormAlumnoAAlumnoDTO(alumnoV, portatil);
					//Convertimos el alumno a dao
					alumno = aDao.AlumnosDTOADAO(alumnoDTO);
					//Ejecutamos la consulta para insertar el alumno
					consulta.insertarUnAlumno(alumno);
					//Metemos en el map el siguiente mensaje para pasarlo a la vista
					miModelo.put("mensaje", "Alumno insertado");
				} else {
					//Si el id de portartil se repite introducimos el siguiente mensaje
					miModelo.put("mensaje", "El portatil no puede ser el mismo para dos alumnos");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		//Devolvemos a la vista el map para así mostrar los mensajes
		return new ModelAndView("formularioInsertAlm", "miModelo", miModelo);
	}

}
