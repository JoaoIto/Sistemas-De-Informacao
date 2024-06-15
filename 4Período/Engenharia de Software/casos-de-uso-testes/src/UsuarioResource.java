package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.Usuario.UsuarioDTO;
import br.unitins.topicos1.services.Usuario.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.logging.Logger;


@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    private static final Logger LOG = Logger.getLogger(String.valueOf(UsuarioResource.class));

    @RolesAllowed({ "User", "Admin" })
    @POST
    public Response insert(UsuarioDTO dto) {
        LOG.info("Cadastrando um usuario.");
        return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    }

    @RolesAllowed({ "User", "Admin" })
    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(UsuarioDTO dto, @PathParam("id") Long id) {
        LOG.info("Fazendo update de um usuario.");
        service.update(dto, id);
        return Response.noContent().build();
    }

    @RolesAllowed({ "Admin" })
    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.info("Deletando um usuario.");
        service.delete(id);
        return Response.noContent().build();
    }

    @RolesAllowed({ "User", "Admin" })
    @GET
    public Response findAll() {
        LOG.info("Busca de todos os usuarios");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @RolesAllowed({ "User", "Admin" })
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.info("Busca de um usuario especificado pelo id.");
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @RolesAllowed({ "streamer", "User", "Admin" })
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.info("Busca de um usuario especificado pelo nome.");
        return Response.ok(service.findByNome(nome)).build();
    }
}
