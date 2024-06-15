package br.unitins.topicos1.dto.Usuario;

import jakarta.validation.constraints.NotBlank;

public record alterarSenhaUsuarioDTO(
        @NotBlank(message = "O campo nome não pode ser nulo.")
        String senha
) {
}
