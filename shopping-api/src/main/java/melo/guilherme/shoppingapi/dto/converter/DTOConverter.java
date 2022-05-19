package melo.guilherme.shoppingapi.dto.converter;

import java.util.stream.Collectors;

import melo.guilherme.shoppingapi.dto.ItemDTO;
import melo.guilherme.shoppingapi.dto.ShopDTO;
import melo.guilherme.shoppingapi.model.Item;
import melo.guilherme.shoppingapi.model.Shop;

public class DTOConverter {

    public static ItemDTO convert(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(
            item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getShoppingDate());
        shopDTO.setItems(shop
            .getItems()
            .stream()
            .map(DTOConverter::convert)
            .collect(Collectors.toList()));
        return shopDTO;
    }
}
