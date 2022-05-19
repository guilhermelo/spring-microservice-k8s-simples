package melo.guilherme.shoppingapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import melo.guilherme.shoppingapi.dto.converter.ProductDTO;

@Service
public class ProductService {

    @Value("${PRODUCT_API_URL:http://localhost:8081/product/}")
    private String urlProduto;

    public ProductDTO getProductByIdentifier(String productIdentifier) {
        RestTemplate restTemplate = new RestTemplate();

        String url = urlProduto + productIdentifier;

        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
        return response.getBody();
    }
}
