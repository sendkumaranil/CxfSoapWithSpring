package com.cxfsoap.example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MoryaAirlinesWebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext webContext=new AnnotationConfigWebApplicationContext();
		webContext.register(MoryaAirlinesConfig.class);
		context.addListener(new ContextLoaderListener(webContext));
		ServletRegistration.Dynamic dispatcher=context.addServlet("CXFServlet", new CXFServlet());
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");
		dispatcher.setInitParameter("contextConfigLocation", "com.cxfsoap.example.config.MoryaAirlinesConfig");
	}

}
