package adapter.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




public class WorkflowClass4 {
	private Map<String, String> deviceTypes = new HashMap<String, String>();
	private Map<String, String> deviceProperties = new HashMap<String, String>();

	public static class Action {

		private String aid;
		private String affects;
		private ArrayList<Link> read_links = new ArrayList<Link>();
		private ArrayList<Link> write_links = new ArrayList<Link>();
		private Input input;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Action() {
		}

		/**
		 * 
		 * @param input
		 * @param affects
		 * @param links
		 * @param aid
		 */
		Action(String aid, String affects, ArrayList<Link> read_links, ArrayList<Link> write_links, Input input) {
			super();
			this.aid = aid;
			this.affects = affects;
			this.read_links = read_links;
			this.write_links = write_links;
			this.input = input;
		}

		@XmlElement
		public String getAid() {
			return aid;
		}

		public void setAid(String aid) {
			this.aid = aid;
		}

		@XmlElement
		public String getAffects() {
			return affects;
		}

		public void setAffects(String affects) {
			this.affects = affects;
		}

		@XmlElement
		public ArrayList<Link> getread_links() {
			return read_links;
		}

		public void setread_links(ArrayList<Link> read_links) {
			this.read_links = read_links;
		}

		@XmlElement
		public ArrayList<Link> getwrite_links() {
			return write_links;
		}

		public void setwrite_links(ArrayList<Link> write_links) {
			this.write_links = write_links;
		}

		@XmlElement
		public Input getInput() {
			return input;
		}

		public void setInput(Input input) {
			this.input = input;
		}

	}

	public static class Input {

		private String units;
		private String datatype;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Input() {
		}

		/**
		 * 
		 * @param datatype
		 * @param units
		 */
		Input(String units, String datatype) {
			super();
			this.units = units;
			this.datatype = datatype;
		}

		@XmlElement
		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

		@XmlElement
		public String getDatatype() {
			return datatype;
		}

		public void setDatatype(String datatype) {
			this.datatype = datatype;
		}

	}

	public static class Link {

		private String href;
		private String mediaType;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Link() {
		}

		/**
		 * 
		 * @param href
		 * @param mediaType
		 */
		Link(String href, String mediaType) {
			super();
			this.href = href;
			this.mediaType = mediaType;
		}

		@XmlElement
		public String getHref() {
			return href;
		}

		public void setHref(String href) {
			this.href = href;
		}

		@XmlElement
		public String getMediaType() {
			return mediaType;
		}

		public void setMediaType(String mediaType) {
			this.mediaType = mediaType;
		}

	}

	public static class Output {

		private String units;
		private String datatype;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Output() {
		}

		/**
		 * 
		 * @param datatype
		 * @param units
		 */
		Output(String units, String datatype) {
			super();
			this.units = units;
			this.datatype = datatype;
		}

		@XmlElement
		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

		@XmlElement
		public String getDatatype() {
			return datatype;
		}

		public void setDatatype(String datatype) {
			this.datatype = datatype;
		}

	}

	public static class Property {

		private String pid;
		private String monitors;
		private Output output;
		private Boolean writable;
		private ArrayList<Link> read_links = new ArrayList<Link>();
		private ArrayList<Link> write_links = new ArrayList<Link>();

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Property() {
		}

		/**
		 * 
		 * @param monitors
		 * @param writable
		 * @param links
		 * @param pid
		 * @param output
		 */
		Property(String pid, String monitors, Output output, Boolean writable, ArrayList<Link> read_links,
				ArrayList<Link> write_links) {
			super();
			this.pid = pid;
			this.monitors = monitors;
			this.output = output;
			this.writable = writable;
			this.read_links = read_links;
			this.write_links = write_links;
		}

		@XmlElement
		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		@XmlElement
		public String getMonitors() {
			return monitors;
		}

		public void setMonitors(String monitors) {
			this.monitors = monitors;
		}

		@XmlElement
		public Output getOutput() {
			return output;
		}

		public void setOutput(Output output) {
			this.output = output;
		}

		@XmlElement
		public Boolean getWritable() {
			return writable;
		}

		public void setWritable(Boolean writable) {
			this.writable = writable;
		}

		@XmlElement
		public ArrayList<Link> getread_links() {
			return read_links;
		}

		public void setread_links(ArrayList<Link> read_links) {
			this.read_links = read_links;
		}

		@XmlElement
		public ArrayList<Link> getwrite_links() {
			return write_links;
		}

		public void setwrite_links(ArrayList<Link> write_links) {
			this.write_links = write_links;
		}

	}

	@XmlRootElement(name = "Response")
	public static class GetObjectsResponse {

		private String type;
		private String oid;
		private ArrayList<Property> properties = new ArrayList<Property>();
		private ArrayList<Action> actions = new ArrayList<Action>();

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		public GetObjectsResponse() {
		}

		/**
		 * 
		 * @param oid
		 * @param properties
		 * @param type
		 * @param actions
		 */
		public GetObjectsResponse(String type, String oid, ArrayList<Property> properties, ArrayList<Action> actions) {
			super();
			this.type = type;
			this.oid = oid;
			this.properties = properties;
			this.actions = actions;
		}

		@XmlElement
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@XmlElement
		public String getOid() {
			return oid;
		}

		public void setOid(String oid) {
			this.oid = oid;
		}

		@XmlElement
		public ArrayList<Property> getProperties() {
			return properties;
		}

		public void setProperties(ArrayList<Property> properties) {
			this.properties = properties;
		}

		@XmlElement
		public ArrayList<Action> getActions() {
			return actions;
		}

		public void setActions(ArrayList<Action> actions) {
			this.actions = actions;
		}

	}

	public class PropertiesActions {
		private ArrayList<Property> properties = new ArrayList<Property>();
		private ArrayList<Action> actions = new ArrayList<Action>();

		PropertiesActions() {

		}

		PropertiesActions(ArrayList<Property> properties, ArrayList<Action> actions) {
			this.properties = properties;
			this.actions = actions;

		}

		public ArrayList<Property> getProperties() {
			return properties;
		}

		public void setProperties(ArrayList<Property> properties) {
			this.properties = properties;
		}

		public ArrayList<Action> getActions() {
			return actions;
		}

		public void setActions(ArrayList<Action> actions) {
			this.actions = actions;
		}

	}

	public ArrayList<GetObjectsResponse> parseResponse() throws Exception {
		// assign inputs to variables

		
		// temporary values
		deviceTypes.put("smartplug", "PowerMeter");
		

		// temporary values
		deviceProperties.put("lightOnOff", "OnOff:true");
		

	
		
		// create class instance to be returned
		ArrayList<GetObjectsResponse> response = new ArrayList<GetObjectsResponse>();
		
		response.add(generateObject());
			
		return response;
	}

	public GetObjectsResponse generateObject() {
		GetObjectsResponse vicinityObject = new GetObjectsResponse();
		
		String oid = "smartplug";
		
		String type = deviceTypes.get(oid);
		
		PropertiesActions p_a = parse();
		vicinityObject = new GetObjectsResponse(type, oid, p_a.getProperties(), p_a.getActions());
		return vicinityObject;

	}

	public PropertiesActions parse() {

		PropertiesActions object = new PropertiesActions();

		// translate ssnProperty to vicinity ssnProperty

		// create Links
		// get
		String read_link_href = "/objects/{oid}/actions/{aid}";
		ArrayList<Link> read_links = new ArrayList<Link>();
		read_links.add(new Link(read_link_href, "application/json"));
		// post
		String write_link_href = "/objects/{oid}/actions/{aid}";

		ArrayList<Link> write_links = new ArrayList<Link>();
		write_links.add(new Link(write_link_href, "application/json"));
		// create a wot:Action
		Action action = new Action("lightOnOff", deviceProperties.get("lightOnOff").split(":")[0], read_links,
				write_links, new Input("Adimensional", ""));
		object.getActions().add(action);

		return object;

	}
}
