package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import com.thoughtworks.rslist.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, OrderRepository orderRepository, ProductRepository productRepository) {
        this.productService = productService;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/product/add")
    public ResponseEntity AddOneProduct(@RequestBody Product product) {
        return productService.AddOneProduct(product);
    }

}
