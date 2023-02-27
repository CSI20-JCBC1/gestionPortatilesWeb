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
import org.springframework.web.bind.annotation.RequestParam;
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

@Controller
public class ControladorInsertAlm {
	@Autowired
	Consultas consulta = new Consultas();

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	Portatiles portatil = new Portatiles();
	AlumnosDTO alumnoDTO = new AlumnosDTO();
	Alumnos alumno = new Alumnos();
	List<PortatilesDTO> listaPortatilesDTO = new ArrayList<PortatilesDTO>();
	List<Portatiles> listaPortatiles = new ArrayList<Portatiles>();

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/navegacionFormularioAlm")
	public ModelAndView navegacionFormulario(Model modelo) {
		try {
			logger.info("Navegamos al formulario");
			FormAlmDTO alumnoForm = new FormAlmDTO();
			List<PortatilesDTO> listaPortatilesDTO2 = new ArrayList<PortatilesDTO>();
			listaPortatiles = consulta.getTodosPortatiles();
			listaPortatilesDTO = aDto.AListaPortatilesDTO(listaPortatiles);
			for (PortatilesDTO prt : listaPortatilesDTO) {
				if (prt.getAlumno() == null)
					listaPortatilesDTO2.add(prt);
			}
			miModelo.put("listaPortatilesDTO2", listaPortatilesDTO2);
			modelo.addAttribute("alumnoV", alumnoForm);

		} catch (Exception e) {
			System.out.println(e);
		}

		return new ModelAndView("formularioInsertAlm", "miModelo", miModelo);
	}

	@RequestMapping(value = "/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoV") FormAlmDTO alumnoV) {

		try {
			if (alumnoV.getIdPortatil() == null||alumnoV.getNombre().isEmpty()||alumnoV.getApellidos().isEmpty()||alumnoV.getNum_telefono().isEmpty()) {

				miModelo.put("mensaje", "Ningún campo puede ser nulo");
				
			} else {
				
				List<Alumnos> listaAlumnos = consulta.getTodosAlumnos();
				Boolean repetido = false;
				for (Alumnos alm : listaAlumnos) {
					if (alm.getPortatiles().getId_ordenador() == alumnoV.getIdPortatil()) {
						repetido = true;
						break;
					}
				}
				if (!repetido) {
					portatil = consulta.selectUnPortatil(alumnoV.getIdPortatil());

					alumnoDTO = aDto.FormAlumnoAAlumnoDTO(alumnoV, portatil);
					alumno = aDao.AlumnosDTOADAO(alumnoDTO);

					consulta.insertarUnAlumno(alumno);

					miModelo.put("mensaje", "Alumno insertado");
				} else {
					miModelo.put("mensaje", "El portatil no puede ser el mismo para dos alumnos");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return new ModelAndView("formularioInsertAlm", "miModelo", miModelo);
	}

}
