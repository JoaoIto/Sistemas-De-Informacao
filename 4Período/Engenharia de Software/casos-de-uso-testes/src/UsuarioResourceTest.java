package br.unitins.topicos1;

import br.unitins.topicos1.dto.Login.LoginDTO;
import br.unitins.topicos1.dto.Usuario.UsuarioResponseDTO;
import br.unitins.topicos1.services.Hash.HashService;
import br.unitins.topicos1.services.Jwt.JwtService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;

import br.unitins.topicos1.dto.Usuario.UsuarioDTO;
import br.unitins.topicos1.services.Usuario.UsuarioService;
import jakarta.inject.Inject;
import static io.restassured.RestAssured.given;
@QuarkusTest
public class UsuarioResourceTest {

    @Inject
    UsuarioService usuarioService;

    @Inject
    JwtService jwtService;

    @Inject
    HashService hashService;

    @Test
    public void testInsert() {
        LoginDTO loginDTO = new LoginDTO("musk", "senha1");
        String hashSenha = hashService.getHashSenha(loginDTO.senha());
        UsuarioResponseDTO result = usuarioService.findByLoginAndSenha(loginDTO.login(), hashSenha.toString());
        // Crie um usuário fictício para o teste
        UsuarioDTO usuarioDTO = new UsuarioDTO(
            "John Doe",
            "john.doe",
            "12312312312" ,
            "senha123",
            1,
            null);

        String tokenUser = jwtService.generateJwt(result);

        // Adicione o token JWT aos cabeçalhos da solicitação
            given()
                    .headers("Authorization", "Bearer " + tokenUser)
                    .contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(usuarioDTO)
                .when().post("/usuarios")
                .then()
                .statusCode(201);
    }

    @Test
    public void testUpdate() {
        // Assumindo que o ID 1 existe no banco de dados
        LoginDTO loginDTO = new LoginDTO("musk", "senha1");
        String hashSenha = hashService.getHashSenha(loginDTO.senha());
        UsuarioResponseDTO result = usuarioService.findByLoginAndSenha(loginDTO.login(), hashSenha.toString());
        // Crie um usuário fictício para o teste
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "John Doe",
                "john.doe",
                "12312312312" ,
                "senha123",
                1,
                null);

        String tokenUser = jwtService.generateJwt(result);
        given()
                .headers("Authorization", "Bearer " + tokenUser)
                .contentType(ContentType.JSON)
            .body(usuarioDTO)
            .when()
            .put("/usuarios/1")
            .then()
            .statusCode(204);
    }

    @Test
    public void testDelete() {
        // Assumindo que o ID 1 existe no banco de dados
        LoginDTO loginDTO = new LoginDTO("gates", "senha2");
        String hashSenha = hashService.getHashSenha(loginDTO.senha());
        UsuarioResponseDTO result = usuarioService.findByLoginAndSenha(loginDTO.login(), hashSenha.toString());
        // Crie um usuário fictício para o teste
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "John Doe",
                "john.doe",
                "12312312312" ,
                "senha123",
                1,
                null);

        String tokenAdm = jwtService.generateJwt(result);
        given()
                .headers("Authorization", "Bearer " + tokenAdm)
                .contentType(ContentType.JSON)
            .when()
            .delete("/usuarios/1")
            .then()
            .statusCode(204);
    }

    @Test
    public void testFindAll() {
        LoginDTO loginDTO = new LoginDTO("musk", "senha1");
        String hashSenha = hashService.getHashSenha(loginDTO.senha());
        UsuarioResponseDTO result = usuarioService.findByLoginAndSenha(loginDTO.login(), hashSenha.toString());
        // Crie um usuário fictício para o teste
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "John Doe",
                "john.doe",
                "12312312312" ,
                "senha123",
                1,
                null);

        String tokenUser = jwtService.generateJwt(result);
        given()
                .headers("Authorization", "Bearer " + tokenUser)
                .contentType(ContentType.JSON)
            .when()
            .get("/usuarios")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindById() {
        // Assumindo que o ID 1 existe no banco de dados
        LoginDTO loginDTO = new LoginDTO("musk", "senha1");
        String hashSenha = hashService.getHashSenha(loginDTO.senha());
        UsuarioResponseDTO result = usuarioService.findByLoginAndSenha(loginDTO.login(), hashSenha.toString());
        // Crie um usuário fictício para o teste
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "John Doe",
                "john.doe",
                "12312312312" ,
                "senha123",
                1,
                null);

        String tokenUser = jwtService.generateJwt(result);
        given()
                .headers("Authorization", "Bearer " + tokenUser)
                .contentType(ContentType.JSON)
            .when()
            .get("/usuarios/1")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindByNome() {
        // Assumindo que o nome "John" existe no banco de dados
        LoginDTO loginDTO = new LoginDTO("musk", "senha1");
        String hashSenha = hashService.getHashSenha(loginDTO.senha());
        UsuarioResponseDTO result = usuarioService.findByLoginAndSenha(loginDTO.login(), hashSenha.toString());
        // Crie um usuário fictício para o teste
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "John Doe",
                "john.doe",
                "12312312312" ,
                "senha123",
                1,
                null);

        String tokenUser = jwtService.generateJwt(result);
        given()
                .headers("Authorization", "Bearer " + tokenUser)
                .contentType(ContentType.JSON)
            .when()
            .get("/usuarios/search/nome/John")
            .then()
            .statusCode(200);
    }
}
