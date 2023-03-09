package edu.dws.gestionPortatilesWeb.web.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Usuario;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADaoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AdaoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.UsuarioDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.ConsultasImpl;

@Controller
public class ControladorLogin {

	@Autowired
	HttpServletRequest request;

	@Autowired
	Consultas consulta = new ConsultasImpl();

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADaoServicio aDao = new AdaoServicioImpl();
	Usuario usuario = new Usuario();

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/navegacionLoginUsu") // Como vamos a llamar a la vista de formularioInsertPrt en nuestro
													// index
	public String navegacionFormulario(Model modelo) {

		try {
			logger.info("Navegamos al formulario");
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			modelo.addAttribute("usuarioV", usuarioDTO);

		} catch (Exception e) {
			System.out.println(e);
		}

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public ModelAndView guardarPortatil(@ModelAttribute("usuarioV") UsuarioDTO usuarioV) {

		try {
			List<Usuario> listaUsuarios = consulta.getTodosUsuarios();
			String nombre = usuarioV.getUsername();
			Boolean existe = false;
			Integer rol;
			for (Usuario usu : listaUsuarios) {
				if (usu.getUsername().equals(nombre)) {
					usuario = consulta.selectUnUsuario(usu.getId());
					rol = usu.getRole();
					existe = true;
					break;
				}

			}
			if (!existe) {
				miModelo.put("mensaje", "El usuario no existe");
			} else if (!usuario.getPassword().equals(usuarioV.getPassword())) {
				miModelo.put("mensaje", "Contraseña incorrecta");
			} else {

				HttpSession session = request.getSession();
				session.setAttribute("rolUsuario", usuario.getRole());
				return new ModelAndView("../index");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return new ModelAndView("login", "miModelo", miModelo);
	}

}
