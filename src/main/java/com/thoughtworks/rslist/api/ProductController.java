package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public ProductController(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/product/add")
    public ResponseEntity shouldAddOneProduct(@RequestBody Product product) {
        List<ProductEntity> temp = productRepository.findByName(product.getName());
        ProductEntity productEntity;
        if (temp.size()==0){
            productEntity = ProductEntity.builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .imgUrl(product.getImgUrl())
                    .unit(product.getUnit())
                    .build();
            productRepository.save(productEntity);
        }else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
