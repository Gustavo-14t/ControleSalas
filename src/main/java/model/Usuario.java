package model;

public class Usuario {
    
     int id_usuario;
    String nome;
    String cpf;
    String senha;
    String cargo;

    public Usuario(int id_usuario, String nome, String cpf, String senha, String cargo) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Usuario(String nome, String cpf, String senha, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
