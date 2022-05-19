package melo.guilherme.shoppingapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import melo.guilherme.shoppingapi.model.Item;

public class ItemDTO {
    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    public static ItemDTO convert(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(
            item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(final String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(final Float price) {
        this.price = price;
    }
}
