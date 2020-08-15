package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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


    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
        OrderEntity orderEntity1 = OrderEntity.builder()
                .name("可乐")
                .price(3)
                .num(3)
                .unit("瓶")
                .build();
        OrderEntity orderEntity2 = OrderEntity.builder()
                .name("雪碧")
                .price(3)
                .num(5)
                .unit("瓶")
                .build();
        orderRepository.save(orderEntity1);
        orderRepository.save(orderEntity2);
    }

    @Test
    void shouldGetOrders() throws Exception {
        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$[0].name", is("可乐")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteOneOrder() throws Exception {
        mockMvc.perform(delete("/order/1/delete"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/product"))
                .andExpect(jsonPath("$.size()",is(1)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAddOneOrder() throws Exception {
        Order order = new Order("雪碧",3,3,"瓶");
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(order);

        mockMvc.perform(post("/order/add")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(2,orderRepository.findAll().size());
    }

}