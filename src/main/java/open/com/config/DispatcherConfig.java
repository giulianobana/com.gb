package open.com.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"open.*"}) 
@Import({HibernateConfig.class ,SecurityConfig.class } )
//@Import({HibernateConfig.class })
public class DispatcherConfig implements  WebMvcConfigurer  {

	// setting property file
    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
    {
    	// define resources
        final List<Resource> resourceLst = new ArrayList<Resource>();
        resourceLst.add(new ClassPathResource("application.properties"));
        resourceLst.add(new ClassPathResource("auth0.properties"));
        resourceLst.add(new ClassPathResource("hibernate.properties"));

        // adding to context
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(resourceLst.toArray(new Resource[]{}));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new  LoginInterceptor());
    }
    

}
