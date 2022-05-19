package melo.guilherme.shoppingapi.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import melo.guilherme.shoppingapi.model.Shop;

public class ShopDTO {
    @NotBlank
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    private Date date;
    @NotNull
    private List<ItemDTO> items;

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(final String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(final Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(final List<ItemDTO> items) {
        this.items = items;
    }
}
