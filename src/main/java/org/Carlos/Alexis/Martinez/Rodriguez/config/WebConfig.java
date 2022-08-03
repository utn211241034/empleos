package org.Carlos.Alexis.Martinez.Rodriguez.config;

// @author carlo

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    //guardar antes de continuar
    //agregar manejador de recursos
    //ESTO SE DEBE ESCRIBIR TAL CUAL, LO ÚNICO QUE SE MODIFICA SON LAS CADENAS
    
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/logos/**").addResourceLocations("file:c:/empleos/img-vacantes/");
	}
    
    
    
    
    

}
























