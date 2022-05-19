package melo.guilherme.shoppingapi.dto.converter;

import java.time.LocalDate;

public class ProductDTO {

    private String productIdentifier;
    private String nome;
    private String descricao;
    private Float preco;
    private CategoryDTO category;

    public ProductDTO() {
    }

    public ProductDTO(final String productIdentifier, final String nome, final String descricao, final Float preco,
        final CategoryDTO category) {
        this.productIdentifier = productIdentifier;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.category = category;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(final String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(final Float preco) {
        this.preco = preco;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(final CategoryDTO category) {
        this.category = category;
    }
}
