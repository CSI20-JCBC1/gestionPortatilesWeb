package edu.dws.gestionPortatilesWeb.web.controladores;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

@Controller
public class ControladorInsertAlm {
	@Autowired
	Consultas consulta = new Consultas();

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	Alumnos alumno = new Alumnos();
	Portatiles portatil=new Portatiles();

	protected final Log logger = LogFactory.getLog(getClass());
	
	 @RequestMapping(value="/navegacionFormularioAlm")
	    public String navegacionFormulario(Model modelo) {
	        logger.info("Navegamos al formulario");
	        AlumnosDTO alumno = new AlumnosDTO();
	        String idPortatil="";
	        modelo.addAttribute("alumnoV", alumno);
	        modelo.addAttribute(idPortatil);
	        return "formularioInsertAlm";
	    } 

	@RequestMapping(value = "/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarPortatil(@RequestParam("idPortatil") String idPortail, @ModelAttribute("alumnoV") AlumnosDTO alumnoV) {

		
		Integer idPortatiln=Integer.parseInt(idPortail);
		
		portatil=consulta.selectUnPortatil(idPortatiln);
		
		alumnoV.setPortatiles(portatil);
		
		alumno=aDao.AlumnosDTOADAO(alumnoV);
		
		consulta.insertarUnAlumno(alumno);
		
		
		
		miModelo.put("mensaje", "Alumno insertado");

		return new ModelAndView("formularioInsertPrt", "miModelo", miModelo);
	}

}
