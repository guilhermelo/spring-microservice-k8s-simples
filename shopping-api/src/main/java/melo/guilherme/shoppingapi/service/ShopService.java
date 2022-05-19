package melo.guilherme.shoppingapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import melo.guilherme.shoppingapi.dto.ItemDTO;
import melo.guilherme.shoppingapi.dto.ShopDTO;
import melo.guilherme.shoppingapi.dto.converter.DTOConverter;
import melo.guilherme.shoppingapi.dto.converter.ProductDTO;
import melo.guilherme.shoppingapi.dto.report.ShopReportDTO;
import melo.guilherme.shoppingapi.model.Shop;
import melo.guilherme.shoppingapi.repository.ReportRepository;
import melo.guilherme.shoppingapi.repository.ShopRepository;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ReportRepository reportRepository;
    private final UserService userService;
    private final ProductService productService;

    public ShopService(final ShopRepository shopRepository,
        final ReportRepository reportRepository, final UserService userService,
        final ProductService productService) {
        this.shopRepository = shopRepository;
        this.reportRepository = reportRepository;
        this.userService = userService;
        this.productService = productService;
    }

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository
            .findAllByUserIdentifier(userIdentifier);
        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        return shopRepository
            .findAllByShoppingDateEquals(shopDTO.getDate())
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public ShopDTO findById(long ProductId) {
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if (shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO, String key) {
        if (userService.getUserByCpf(shopDTO.getUserIdentifier(), key) == null) {
            return null;
        }
        if (!validateProducts(shopDTO.getItems())) {
            return null;
        }
        shopDTO.setTotal(shopDTO.getItems()
            .stream()
            .map(ItemDTO::getPrice)
            .reduce((float) 0, Float::sum));

        Shop shop = Shop.convert(shopDTO);
        shop.setShoppingDate(new Date());
        shop = shopRepository.save(shop);
        return DTOConverter.convert(shop);
    }

    private boolean validateProducts(List<ItemDTO> items) {
        for (ItemDTO item : items) {
            ProductDTO productDTO = productService.getProductByIdentifier(item.getProductIdentifier());
            if (productDTO == null) {
                return false;
            }
            item.setPrice(productDTO.getPreco());
        }
        return true;
    }

    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
        return reportRepository.getShopByFilters(dataInicio, dataFim, valorMinimo)
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        return reportRepository.getReportByDate(dataInicio, dataFim);
    }

}
