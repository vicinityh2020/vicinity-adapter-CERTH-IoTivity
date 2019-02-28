package adapter.services;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.iotivity.base.examples.SimpleClient;

import adapter.services.WorkflowClass.Variable;


public class WorkflowClass2 {
	
	private Variable aid = new Variable("aid", "", "String");
	private Variable oid = new Variable("oid", "", "String");


	@XmlRootElement(name = "Response")
	public static class GetResponse {
		private boolean value;
		private String timestamp;

		public GetResponse() {
		}

		public GetResponse(boolean value, String timestamp) {
			this.value = value;
			this.timestamp = timestamp;
		}

		public void setvalue(boolean value) {
			this.value = value;
		}

		@XmlElement
		public boolean getvalue() {
			return value;
		}

		public void settimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		@XmlElement
		public String gettimestamp() {
			return timestamp;
		}
	}
	
	public GetResponse parseResponse(String aid, String oid) throws Exception {
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
		
		boolean getresponse = SimpleClient.callGet(aid, oid);
		
		LocalDateTime now = LocalDateTime.now();
		String timestamp = now + "+0300";
 
		
		// create class instance to be returned
		GetResponse response = new GetResponse(getresponse, timestamp);
		return response;
	}
}
