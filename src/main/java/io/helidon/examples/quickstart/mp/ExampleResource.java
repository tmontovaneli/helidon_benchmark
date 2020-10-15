package io.helidon.examples.quickstart.mp;

import io.helidon.examples.quickstart.mp.jpa.Greeting;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/db")
@RequestScoped
public class ExampleResource {

    @PersistenceContext
    private EntityManager em;


    @GET
    @Path("response/{salutation}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Greeting getResponse(@PathParam("salutation") String salutation) {
        return this.em.find(Greeting.class, salutation);
    }


}
