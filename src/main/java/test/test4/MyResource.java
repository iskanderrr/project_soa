package test.test4;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import test.test4.dao.DonationDao;

import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    DonationDao dao = new DonationDao();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllUsers() {
        return "ddddddddd";
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(Donation donation) {
        try {
            dao.addDonation(donation);
            System.out.println("Donation added: " + donation); // Log donation object
            return Response.status(Response.Status.CREATED).entity(donation).build();
        } catch (Exception e) {
            System.out.println("Error in adding donation: " + e.getMessage()); // Log exception
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error processing request").build();
        }
    }

}
