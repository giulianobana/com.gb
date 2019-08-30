package open.com.config;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import open.com.model.object.Auth0User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	final static Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
    throws Exception {
    // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    throws Exception {
    // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	logger.error("Autho0.com");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", new String(request.getHeader("Authorization")));
		RestTemplate restTemplate = new RestTemplate();
		URI url = new URI("https://gbproject.auth0.com/userinfo");
		HttpEntity requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Auth0User> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Auth0User.class);
		request.setAttribute("user", result.getBody().getEmail());
		return true;
    }


}