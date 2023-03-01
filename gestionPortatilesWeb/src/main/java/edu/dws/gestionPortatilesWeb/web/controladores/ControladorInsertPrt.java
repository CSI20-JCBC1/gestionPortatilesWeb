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
import org.springframework.web.servlet.ModelAndView;


import edu.dws.gestionPortatilesWeb.aplicacion.dal.Portatiles;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADaoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AdaoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.PortatilesDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.ConsultasImpl;

@Controller
public class ControladorInsertPrt {

	//Declaramos todo lo que vamos a usar.
	@Autowired
	Consultas consulta = new ConsultasImpl();

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	Portatiles portatil = new Portatiles();

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/navegacionFormularioPrt")//Como vamos a llamar a la vista de formularioInsertPrt en nuestro index
	public String navegacionFormulario(Model modelo) {
		
		try {
			logger.info("Navegamos al formulario");
			//Creamos un portatil dto con el que recogeremos los datos del form en la vista y se lo pasamos a la misma
			PortatilesDTO portatil = new PortatilesDTO();
			modelo.addAttribute("portatilV", portatil);

		} catch (Exception e) {
			System.out.println(e);
		}

		//Volvemos a la vista
		return "formularioInsertPrt";
	}

	
	@RequestMapping(value = "/guardarPortatil", method = RequestMethod.POST)//Donde va a buscar la vista al enviar el formulario en la propiedad action.
	public ModelAndView guardarPortatil(@ModelAttribute("portatilV") PortatilesDTO portatilV) {

		try {
			//Comprobamos si los datos recogidos de la vista son nulos si son nulos mandamos el siguiente mensaje
			if (portatilV.getMarca().isEmpty() || portatilV.getModelo().isEmpty()) {
				miModelo.put("mensaje", "Los campos no pueden ser nulos");
			} else {
				//Si no son nulos, convertimos a dao el portatil recogido con la vista
				portatil = aDao.PortatilesDTOADAO(portatilV);
				//Hacemos una consulta para insertar el portatil
				consulta.insertarUnPortatil(portatil);
				//Añadimos al mapa un mensje de que el portatil se ha insertado correctamente
				miModelo.put("mensaje", "Portatil insertado");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		//Devolvemos la vista y le pasamos el map para que muestre el mensaje
		return new ModelAndView("formularioInsertPrt", "miModelo", miModelo);
	}

}
