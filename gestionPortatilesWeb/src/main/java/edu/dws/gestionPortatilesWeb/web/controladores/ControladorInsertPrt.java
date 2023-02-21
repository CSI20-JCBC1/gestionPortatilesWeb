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
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AdaoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.PortatilesDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;

@Controller
public class ControladorInsertPrt {

	@Autowired
	Consultas consulta = new Consultas();

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	Portatiles portatil=new Portatiles();

	protected final Log logger = LogFactory.getLog(getClass());
	
	 @RequestMapping(value="/navegacionFormularioPrt")
	    public String navegacionFormulario(Model modelo) {
	        logger.info("Navegamos al formulario");
	        PortatilesDTO portatil = new PortatilesDTO();
	        modelo.addAttribute("portatilV", portatil);
	        return "formularioInsertPrt";
	    } 

	@RequestMapping(value = "/guardarPortatil", method = RequestMethod.POST)
	public ModelAndView guardarPortatil(@ModelAttribute("portatilV") PortatilesDTO portatilV) {

		
		
		portatil=aDao.PortatilesDTOADAO(portatilV);
		
		consulta.insertarUnPortatil(portatil);
		
		miModelo.put("mensaje", "Portatil insertado");

		return new ModelAndView("formularioInsertPrt", "miModelo", miModelo);
	}

}
