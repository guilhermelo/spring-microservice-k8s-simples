package melo.guilherme.shoppingapi.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import melo.guilherme.shoppingapi.dto.ShopDTO;

@Entity(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userIdentifier;
    private float total;
    private Date shoppingDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setTotal(shopDTO.getTotal());
        shop.setShoppingDate(shopDTO.getDate());
        shop.setItems(shopDTO
            .getItems()
            .stream()
            .map(Item::convert)
            .collect(Collectors.toList()));
        return shop;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(final String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(final float total) {
        this.total = total;
    }

    public Date getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(final Date shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }
}
