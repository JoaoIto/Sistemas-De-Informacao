package br.unitins.topicos1.services.Usuario;

import java.util.List;

import br.unitins.topicos1.dto.Usuario.UsuarioDTO;
import br.unitins.topicos1.dto.Usuario.UsuarioResponseDTO;
import br.unitins.topicos1.dto.Usuario.alterarSenhaUsuarioDTO;
import jakarta.validation.Valid;

public interface UsuarioService {

    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto);

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);
    public UsuarioResponseDTO alterarSenha(alterarSenhaUsuarioDTO alterarSenhaUsuarioDTO, String login);

    public void delete(Long id);
    
    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    public UsuarioResponseDTO findByLogin(String login);

    public List<UsuarioResponseDTO> findByAll(); 
    
}
