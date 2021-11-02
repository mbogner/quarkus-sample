package dev.mbo.quarkus.sample.resource

import dev.mbo.quarkus.sample.service.HealthService
import org.eclipse.microprofile.openapi.annotations.Operation
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/actuator/health")
class HealthResource @Inject constructor(private val healthService: HealthService) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(description = "Shows health status of the application")
    fun health(): String {
        return healthService.health()
    }
}
