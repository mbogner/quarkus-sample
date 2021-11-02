package dev.mbo.quarkus.sample.resource;

import dev.mbo.quarkus.sample.model.Person;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

  @GET
  public List<Person> list() {
    return Person.listAll();
  }

  @GET
  @Path("/{id}")
  public Person get(@PathParam("id") final Long id) {
    return Person.findById(id);
  }

  @POST
  @Transactional
  public Response create(final Person person) {
    person.persist();
    return Response.created(URI.create("/persons/" + person.id)).build();
  }

  @PUT
  @Path("/{id}")
  @Transactional
  public Person update(
    @PathParam("id") final Long id,
    final Person person
  ) {
    Person entity = Person.findById(id);
    if (entity == null) {
      throw new NotFoundException();
    }

    // map all fields from the person parameter to the existing entity
    entity.name = person.name;

    return entity;
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public void delete(@PathParam("id") final Long id) {
    Person entity = Person.findById(id);
    if (entity == null) {
      throw new NotFoundException();
    }
    entity.delete();
  }

  @GET
  @Path("/search/{name}")
  public Person search(@PathParam("name") final String name) {
    return Person.findByName(name);
  }

  @GET
  @Path("/count")
  public Long count() {
    return Person.count();
  }
}
