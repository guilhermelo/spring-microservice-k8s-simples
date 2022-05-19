package melo.guilherme.productapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import melo.guilherme.productapi.model.Product;

public class ProductDTO {
    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Float preco;
    @NotNull
    private CategoryDTO category;

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(
            product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());
        if (product.getCategory() != null) {
            productDTO.setCategory(
                CategoryDTO.convert(product.getCategory()));
        }
        return productDTO;
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
