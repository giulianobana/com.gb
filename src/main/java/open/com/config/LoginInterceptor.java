package open.com.config;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import open.com.model.Auth0User;

public class LoginInterceptor extends HandlerInterceptorAdapter {

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

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", new String(request.getHeader("Authorization")));
		RestTemplate restTemplate = new RestTemplate();
		URI url = new URI("https://gbproject.auth0.com/userinfo");
		HttpEntity requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Auth0User> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Auth0User.class);
		// StringUtils.isEmpty(password) || StringUtils.containsWhitespace(password)) {
		// throw new Exception("Invalid User Id or Password. Please try again.");
		// }
		request.setAttribute("user", result.getBody().getName());
		return true;
    }


}