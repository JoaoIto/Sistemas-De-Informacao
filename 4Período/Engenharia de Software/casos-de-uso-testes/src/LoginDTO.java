package br.unitins.topicos1.dto.Login;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO (
    @NotEmpty(message = "O campo login não pode ser nulo.")
    String login,
    @NotEmpty(message = "O campo senha não pode ser nulo.")
    String senha
) {

}
