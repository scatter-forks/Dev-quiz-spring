package com.thoughtworks.rslist.service;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity AddOneProduct(Product product){
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
