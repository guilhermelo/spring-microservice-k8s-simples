package melo.guilherme.productapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import melo.guilherme.productapi.dto.ProductDTO;
import melo.guilherme.productapi.model.Product;
import melo.guilherme.productapi.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products
            .stream()
            .map(ProductDTO::convert)
            .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        List<Product> products =
            productRepository.getProductByCategory(categoryId);
        return products
            .stream()
            .map(ProductDTO::convert)
            .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(
        String productIdentifier) {
        Product product =
            productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductDTO.convert(product);
        }
        return null;
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product =
            productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

    public void delete(long productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
    }
}
