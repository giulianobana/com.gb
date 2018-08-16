package open.com.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ResponseObject")
public class ResponseObject {

	private Object object;
	private List<Messages> errors = new ArrayList<>();
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public List<Messages> getErrors() {
		return errors;
	}
	public void setErrors(List<Messages> errors) {
		this.errors = errors;
	}
	public void addError(Messages error) {
		this.errors.add(error) ;
	}

	public class  Messages {		

		String level;
		String code;
		String message;
		
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
	}

	
	}

