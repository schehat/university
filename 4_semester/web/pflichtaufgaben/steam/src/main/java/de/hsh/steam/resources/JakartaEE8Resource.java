package de.hsh.steam.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author lushaj
 */
@Path("rest")
public class JakartaEE8Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}