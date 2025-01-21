package test.test4;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import test.test4.dao.DonationDao;

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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        return Response.ok(dao.getAllDonations()).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(Donation donation) {
        dao.addDonation(donation);
        return Response.status(Response.Status.CREATED).entity(donation).build();
    }
}
