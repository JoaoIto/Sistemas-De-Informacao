package com.topicos.resource;

import com.topicos.model.Estado;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/estados")
public class EstadoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> estados(){
        return Estado.listAll();
    }
}
