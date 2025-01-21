package test.test4;

import jakarta.ws.rs.*;
import test.test4.dao.DonationDao;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        return Response.ok(dao.getAllDonations()).build();
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

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDonation(@PathParam("id") int id, Donation donation) {
        try {
            Donation updatedDonation = dao.updateDonation(id, donation);
            if (updatedDonation != null) {
                return Response.ok(updatedDonation).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Donation not found for ID: " + id).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDonationById(@PathParam("id") int id) {
        try {
            Donation donation = dao.getDonationById(id);
            if (donation != null) {
                return Response.ok(donation).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Donation not found for ID: " + id).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDonationById(@PathParam("id") int id) {
        try {
            boolean isDeleted = dao.deleteDonationById(id);
            if (isDeleted) {
                return Response.ok("Donation deleted successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Donation not found for ID: " + id).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error: " + e.getMessage()).build();
        }
    }


}

