package adapter.services;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.iotivity.base.examples.SimpleClient;



public class WorkflowClass {
	
	private Variable aid = new Variable("aid", "", "String");
	private Variable oid = new Variable("oid", "", "String");
	private Variable param_value = new Variable("value", "", "String");
	private IotivityRequest Iotivity_request = new IotivityRequest();
	
	@XmlRootElement(name = "Response")
	public static class Response {
		private String message;

		public Response() {
		}

		public Response(String message) {
			this.message = message;
		}

		public void setmessage(String message) {
			this.message = message;
		}

		@XmlElement
		public String getmessage() {
			return message;
		}
	}

	public static class Input {

		private String parameterName;
		private String parameterValue;
		
		public Input() {
			
		}
		
		public Input(String parameterName, String parameterValue) {
			this.parameterName = parameterName;
			this.parameterValue = parameterValue;
		}

		@XmlElement(name = "parameterName")
		public String getparameterName() {
			return parameterName;
		}

		public void setparameterName(String parameterName) {
			this.parameterName = parameterName;
		}

		@XmlElement (name = "parameterValue")
		public String getparameterValue() {
			return parameterValue;
		}

		public void setparameterValue(String parameterValue) {
			this.parameterValue = parameterValue;
		}

	}

	@XmlRootElement
	public static class IotivityRequest {

		private ArrayList<Input> input = new ArrayList<Input>();

		public IotivityRequest(ArrayList<Input> input) {
			this.input = input;
		}

		public IotivityRequest() {
			// TODO Auto-generated constructor stub
		}

		@XmlElement(name = "input")
		public ArrayList<Input> getinput() {
			return input;
		}

		public void setinput(ArrayList<Input> input) {
			this.input = input;
		}

	}
	
	public static class Variable {
		public String name;
		public String value;
		public String type;
		public ArrayList<Variable> subtypes = new ArrayList<Variable>();
		public ArrayList<Variable> arrayElements = new ArrayList<Variable>();

		Variable(String name, String value, String type) {
			this.name = name;
			this.value = value;
			this.type = type;
		}

		Variable(Variable prototype) {
			this.name = prototype.name;
			this.value = prototype.value;
			this.type = prototype.type;
			for (Variable sub : prototype.subtypes) {
				Variable arg = new Variable(sub);
				subtypes.add(arg);
			}
			for (Variable el : prototype.arrayElements) {
				Variable arg = new Variable(el);
				arrayElements.add(arg);
			}
		}

		public Variable getSubtype(String name) {
			for (Variable sub : subtypes) {
				if (sub.name.equals(name.replaceAll("[^A-Za-z]", ""))) {
					return sub;
				}
			}
			return null;
		}
	}
	
	public Response parseResponse(String aid, String oid, IotivityRequest request){
		// assign uri parameters to variables
		if (aid == null) {
			this.aid.value = "";
		} else {
			this.aid.value = aid;
		}
		if (oid == null) {
			this.oid.value = "";
		} else {
			this.oid.value = oid;
		}
		
		Iotivity_request = new IotivityRequest(request.getinput());
		if (Iotivity_request.getinput() != null && !Iotivity_request.getinput().isEmpty() && Iotivity_request.getinput().get(0).getparameterValue() != null){
			this.param_value.value = Iotivity_request.getinput().get(0).getparameterValue();
		}
		
		SimpleClient.callPost(aid, oid, Boolean.parseBoolean(this.param_value.value));
		// create class instance to be returned
		Response response = new Response();
		response.setmessage("Done");
		return response;
	}
}
