package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        ProductEntity productEntity1 = ProductEntity.builder()
                .category("蔬菜")
                .name("洋葱")
                .price(1)
                .imgUrl("http")
                .unit("斤")
                .build();
        ProductEntity productEntity2 = ProductEntity.builder()
                .category("蔬菜")
                .name("茄子")
                .price(3)
                .imgUrl("http")
                .unit("斤")
                .build();
        ProductEntity productEntity3 = ProductEntity.builder()
                .category("蔬菜")
                .name("大米")
                .price(5)
                .imgUrl("http")
                .unit("斤")
                .build();
        ProductEntity productEntity4 = ProductEntity.builder()
                .category("蔬菜")
                .name("啤酒")
                .price(3)
                .imgUrl("http")
                .unit("瓶")
                .build();
        productRepository.save(productEntity1);
        productRepository.save(productEntity2);
        productRepository.save(productEntity3);
        productRepository.save(productEntity4);
    }

    @Test
    void shouldAddOneProduct() throws Exception {
        Product product = new Product("蔬菜","虾米", 20, "斤", "www");
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/product/add")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotAddOneProductWhenExist() throws Exception {
        Product product = new Product("蔬菜","啤酒", 20, "斤", "www");
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/product/add")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}