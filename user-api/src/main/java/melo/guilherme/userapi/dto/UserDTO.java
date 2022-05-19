package melo.guilherme.userapi.dto;

import java.time.LocalDate;

import melo.guilherme.userapi.domain.User;

public class UserDTO {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;

    public UserDTO() {
    }

    private UserDTO(String nome, String cpf, String endereco, String email, String telefone,
        LocalDate dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public static UserDTO from(User user) {
        return new UserDTO(user.getNome(), user.getCpf(), user.getEndereco(),
            user.getEmail(), user.getTelefone(), user.getDataCadastro());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(final String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(final LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
