package melo.guilherme.userapi.domain;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;
    private String key;


    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public User(final UserBuilder builder) {
        this.nome = builder.nome;
        this.cpf = builder.cpf;
        this.endereco = builder.endereco;
        this.email = builder.email;
        this.telefone = builder.telefone;
        this.dataCadastro = builder.dataCadastro;
        this.key = UUID.randomUUID().toString();
    }

    private User() {}

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public static class UserNotFoundException extends RuntimeException {
    }
}
