package service.Impl;

import dto.ProductRequest;
import dto.ProductResponse;
import dto.SimpleResponse;
import entities.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repo.ProductRepo;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public SimpleResponse createProduect(ProductResponse productResponse) {
        Product product = new Product();
        log.info("request:{}", productResponse);
        product.setId(productResponse.getId());
        product.setProductDescription(productResponse.getProductDescription());
        product.setProductPrice(productResponse.getProductPrice());
        product.setProductQuantity(productResponse.getProductQuantity());
        productRepo.save(product);
        log.info("Order created successfully order: {}", product);
        return SimpleResponse.builder().httpStatus(HttpStatus.OK).messageCode(
                "Order created successfully order").build();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        return ProductResponse.builder()
                .id(product.get().getId())
                .productDescription(product.get().getProductDescription())
                .productPrice(product.get().getProductPrice())
                .productQuantity(product.get().getProductQuantity())
                .productName(product.get().getProductName())
                .build();
    }

    @Override
    public SimpleResponse updateProduct(ProductResponse productResponse, Long id) {
        Product product = productRepo.findById(id).orElse(null);
        product.setProductDescription(productResponse.getProductDescription());
        product.setProductPrice(productResponse.getProductPrice());
        product.setProductQuantity(productResponse.getProductQuantity());
        product.setProductName(productResponse.getProductName());
        return SimpleResponse.builder().httpStatus(HttpStatus.OK).messageCode
                ("Order updated successfully order").build();
    }

    @Override
    public SimpleResponse deleteProduct(Long id) {
        Product product = productRepo.findById(id).orElse(null);
        assert product != null;
        productRepo.delete(product);
        return SimpleResponse.builder().httpStatus(HttpStatus.OK).messageCode
                ("Order deleted successfully order").build();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll().stream().toList();

    }
}
