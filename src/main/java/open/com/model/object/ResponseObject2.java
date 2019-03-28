package open.com.model.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class ResponseObject2 {

	private Object result;
	private List<Messages> messages = new ArrayList<>();
	
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public List<Messages> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	public void addMessage(Messages error) {
		this.messages.add(error) ;
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

