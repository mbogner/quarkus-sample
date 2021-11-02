package dev.mbo.quarkus.sample.resource

import dev.mbo.quarkus.sample.model.Person
import java.net.URI
import javax.transaction.Transactional
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class PersonResource {

    @GET
    fun list(): List<Person> {
        return Person.listAll()
    }

    @GET
    @Path("/{id}")
    operator fun get(@PathParam("id") id: Int): Person {
        return Person.findById(id)
    }

    @POST
    @Transactional
    fun create(person: Person): Response {
        person.persist()
        return Response.created(URI.create("/persons/" + person.id)).build()
    }

    @PUT
    @Path("/{id}")
    @Transactional
    fun update(
        @PathParam("id") id: Int,
        person: Person
    ): Person {
        val entity: Person = Person.findById(id)

        // map all fields from the person parameter to the existing entity
        entity.name = person.name
        return entity
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    fun delete(@PathParam("id") id: Int) {
        Person.deleteById(id)
    }

    @GET
    @Path("/search/{name}")
    fun search(@PathParam("name") name: String?): Person {
        return Person.findByName(name!!)
    }

    @GET
    @Path("/count")
    fun count(): Long {
        return Person.count()
    }
}
