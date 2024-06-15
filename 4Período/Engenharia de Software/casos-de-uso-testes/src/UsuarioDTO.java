package br.unitins.topicos1.dto.Usuario;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO (
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    String login,
    String cpf,
    String senha,
    Integer idPerfil,
    List<TelefoneDTO> listaTelefone
) {

}
