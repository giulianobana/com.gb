package open.com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitialiazer implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		  
//	      XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//	      appContext.setConfigLocation("/WEB-INF/spring-mvc.xml");
	      // Create the dispatcher servlet's Spring application context
	      AnnotationConfigWebApplicationContext dispatcherContext =     new AnnotationConfigWebApplicationContext();
	      dispatcherContext.register(DispatcherConfig.class);

	      ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
	    
	      dispatcher.setLoadOnStartup(1);
	      dispatcher.addMapping("/");
	    
	}
}
//
//import org.springframework.web.servlet.support.*;
//
////public class MvcWebApplicationInitializer
//    extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return null;
//    }
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class[] {DispatcherConfig.class};
//		
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		// TODO Auto-generated method stub
//		return new String[] {"/"};
//	}
//
//    // ... other overrides ...
//}

