package edu.dws.gestionPortatilesWeb.web.controladores;

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

import edu.dws.gestionPortatilesWeb.aplicacion.dal.Usuario;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.ADaoServicio;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.AdaoServicioImpl;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.RegistroDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.dto.UsuarioDTO;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.Consultas;
import edu.dws.gestionPortatilesWeb.aplicacion.impl.ConsultasImpl;
@Controller
public class ControladorRegistro {
	
	//Declaramos todo lo que vamos a usar.
		@Autowired
		Consultas consulta = new ConsultasImpl();

		Map<String, Object> miModelo = new HashMap<String, Object>();
		ADaoServicio aDao = new AdaoServicioImpl();
		Usuario usuario = new Usuario();

		protected final Log logger = LogFactory.getLog(getClass());

		@RequestMapping(value = "/navegacionRegistroUsu")//Como vamos a llamar a la vista de formularioInsertPrt en nuestro index
		public String navegacionFormulario(Model modelo) {
			
			try {
				logger.info("Navegamos al formulario");
				//Creamos un portatil dto con el que recogeremos los datos del form en la vista y se lo pasamos a la misma
				RegistroDTO registroDTO = new RegistroDTO();
				modelo.addAttribute("usuarioV", registroDTO);

			} catch (Exception e) {
				System.out.println(e);
			}

			//Volvemos a la vista
			return "registro";
		}

		
		@RequestMapping(value = "/registrar", method = RequestMethod.POST)//Donde va a buscar la vista al enviar el formulario en la propiedad action.
		public ModelAndView guardarPortatil(@ModelAttribute("usuarioV") RegistroDTO usuarioV) {

			
			try {
				List<Usuario> listaUsuarios=consulta.getTodosUsuarios();
				Boolean existe=false;
				for(Usuario usu : listaUsuarios) {
					if(usu.getUsername().equals(usuarioV.getUsername())||usu.getEmail().equals(usuarioV.getEmail())) {
						existe=true;
						break;
					}
				}
				if(!(usuarioV.getPassword().equals(usuarioV.getPassword2()))) {
					miModelo.put("mensaje", "Las contraseñas no coinciden");
				}
				else if(existe){
					miModelo.put("mensaje", "El usuario ya existe o ya esta en uso el correo");
				}
				else {
					
					UsuarioDTO usuarioDTO=new UsuarioDTO(usuarioV.getUsername(),usuarioV.getEmail(), usuarioV.getPassword(), usuarioV.getRole());

					usuario = aDao.UsuarioDTOADAO(usuarioDTO);

					consulta.insertarUnUsuario(usuario);

					miModelo.put("mensaje", "Registro completado");
				}

				
				
					
			

			} catch (Exception e) {
				System.out.println(e);
			}

			//Devolvemos la vista y le pasamos el map para que muestre el mensaje
			return new ModelAndView("registro", "miModelo", miModelo);
		}

}
