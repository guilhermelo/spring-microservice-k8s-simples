package melo.guilherme.userapi.domain;

import java.time.LocalDate;

public class UserBuilder {
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String email;
    protected String telefone;
    protected LocalDate dataCadastro;

    public UserBuilder nome(final String nome) {
        this.nome = nome;
        return this;
    }

    public UserBuilder cpf(final String cpf) {
        this.cpf = cpf;
        return this;
    }

    public UserBuilder endereco(final String endereco) {
        this.endereco = endereco;
        return this;
    }

    public UserBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public UserBuilder telefone(final String telefone) {
        this.telefone = telefone;
        return this;
    }

    public UserBuilder dataCadastro(final LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public User build() {
        return new User(this);
    }
}
