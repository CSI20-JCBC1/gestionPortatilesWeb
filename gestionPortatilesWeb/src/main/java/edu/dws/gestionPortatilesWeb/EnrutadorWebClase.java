package edu.dws.gestionPortatilesWeb;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import edu.dws.gestionPortatilesWeb.aplicacion.AplicacionConfiguracionContexto;
import edu.dws.gestionPortatilesWeb.web.WebConfiguracionContexto;



public class EnrutadorWebClase extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AplicacionConfiguracionContexto.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfiguracionContexto.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
