package br.unitins.topicos1.model.Usuario;

import java.util.List;

import br.unitins.topicos1.model.DefaultEntity;
import br.unitins.topicos1.model.Stream;
import jakarta.persistence.*;

@Entity
public class Usuario extends DefaultEntity {

    private String nome;
    private String login;

    private String cpf;
    private String senha;
    //@Enumerated(EnumType.ORDINAL)
    private Perfil perfil;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "usuario_telefone", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_telefone"))
    private List<Telefone> listaTelefone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Stream> streams;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}
