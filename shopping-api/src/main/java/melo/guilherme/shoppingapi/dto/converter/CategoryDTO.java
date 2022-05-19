package melo.guilherme.shoppingapi.dto.converter;

public class CategoryDTO {
    private Long id;
    private String nome;

    public CategoryDTO() {
    }

    public CategoryDTO(final Long id, final String nome) {
        this.id = id;
        this.nome = nome;
    }
}
