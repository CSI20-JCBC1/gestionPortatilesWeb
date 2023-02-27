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

@Controller
public class ControladorAlumnoPorIdPortatil {

	@Autowired
	Consultas consulta = new Consultas();

	List<Portatiles> listaPortatiles = new ArrayList<Portatiles>();
	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	ADtoServicio aDto = new ADtoServicioImpl();
	List<PortatilesDTO> listaPortatilesDTO = new ArrayList<PortatilesDTO>();
	Alumnos alumno = new Alumnos();
	PortatilesDTO portatilDTO = new PortatilesDTO();
	Portatiles portatil = new Portatiles();

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/navegacionFormularioAlumnoPorIdPortatil")
	public ModelAndView navegacionFormulario(Model modelo) {
		try {
			listaPortatiles = consulta.getTodosPortatiles();
			listaPortatilesDTO = aDto.AListaPortatilesDTO(listaPortatiles);
			List<PortatilesDTO> listaPortatilesDTO2 = new ArrayList<PortatilesDTO>();
			for (PortatilesDTO prt : listaPortatilesDTO) {
				if (prt.getAlumno() != null)
					listaPortatilesDTO2.add(prt);

			}
			miModelo.put("listaPortatilesDTO2", listaPortatilesDTO2);
			PortatilesDTO portatilDTO = new PortatilesDTO();
			modelo.addAttribute("portatilV", portatilDTO);

		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("selectAlmPorIdPrt", "miModelo", miModelo);

	}

	@RequestMapping(value = "/buscarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("portatilV") PortatilesDTO portatilV) {

		try {

			portatil = consulta.selectUnPortatil(portatilV.getId_ordenador());

			alumno = consulta.selectUnAlumno(portatil.getAlumno().getId_alumno());

			AlumnosDTO alumnoDTO = aDto.AAlumnosDTO(alumno.getId_alumno(), alumno.getMd_uuid(), alumno.getMd_date(),
					alumno.getNombre(), alumno.getApellidos(), alumno.getNum_telefono(), alumno.getPortatiles());

			miModelo.put("mensaje", alumnoDTO.toString());

		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("selectAlmPorIdPrt", "miModelo", miModelo);
	}

}
