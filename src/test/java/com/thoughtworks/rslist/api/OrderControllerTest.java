package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;


    @Test
    void shouldAddOneOrder() throws Exception {
//        OrderEntity orderEntity = OrderEntity.builder()
//                .name("可乐")
//                .price(3)
//                .num(3)
//                .unit("瓶")
//                .build();
//        orderRepository.save(orderEntity);
        System.out.println("=======华丽的分割线=======");
        mockMvc.perform(get("/product")) //.andExpect(jsonPath("$",is("sdsad")))
                .andExpect(status().isOk());
    }

//    @Test
//    void shoudGetOrderList() {
//
//    }
}