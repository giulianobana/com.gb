package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitialiazer implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		  
//	      XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//	      appContext.setConfigLocation("/WEB-INF/spring-mvc.xml");
	      // Create the dispatcher servlet's Spring application context
		  
	      AnnotationConfigWebApplicationContext dispatcherContext =
	        new AnnotationConfigWebApplicationContext();
	      dispatcherContext.register(DispatcherConfig.class);
	      

	      ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
	      dispatcher.setLoadOnStartup(1);
	      dispatcher.addMapping("/");
	    
	}

}