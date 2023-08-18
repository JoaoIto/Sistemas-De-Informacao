package resources;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import models.cadastro.Cadastro;

import java.util.List;

@Path("/cadastro")
public class CadastroResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cadastro> estados(){
        return Cadastro.listAll();
    }
}
