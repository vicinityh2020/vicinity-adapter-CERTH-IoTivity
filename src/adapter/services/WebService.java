package adapter.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import adapter.services.WorkflowClass.IotivityRequest;
import adapter.services.WorkflowClass.Response;
import adapter.services.WorkflowClass2.GetResponse;
import adapter.services.WorkflowClass4.GetObjectsResponse;
@Path("/objects")
 public class WebService {
	
	@POST
    @Path("/{oid}/actions/{aid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateResponse(@PathParam("oid") String oid, @PathParam("aid") String aid, IotivityRequest request) throws Exception {
        WorkflowClass newClass = new WorkflowClass();
        Response response = newClass.parseResponse(aid, oid, request);
        return response;
    }
	
	
	@GET
    @Path("/{oid}/actions/{aid}")
    @Produces(MediaType.APPLICATION_JSON)
    public GetResponse generateResponse(@PathParam("aid") String aid, @PathParam("oid") String oid) throws Exception {
        WorkflowClass2 newClass = new WorkflowClass2();
        GetResponse response = newClass.parseResponse(aid, oid);
        return response;
    }
	
	
//	@PUT
//    @Path("/{oid}/properties/{pid}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public PutResponse generateResponse(@PathParam("pid") String pid, @PathParam("oid") String oid, SiteWhereAdapterPUTRequest request) throws Exception {
//        WorkflowClass3 newClass = new WorkflowClass3();
//        PutResponse response = newClass.parseResponse(pid, oid, request);
//        return response;
//    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<GetObjectsResponse> generateResponse() throws Exception {
        WorkflowClass4 newClass = new WorkflowClass4();
        ArrayList<GetObjectsResponse> response = newClass.parseResponse();
        return response;
    }
}
