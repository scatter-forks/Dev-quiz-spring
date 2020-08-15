package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.hamcrest.Matchers;
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


    @Test
    void shouldGetOrders() throws Exception {
        mockMvc.perform(get("/product"))
                .andExpect(jsonPath("$[0].name", is("可乐")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteOneOrder() throws Exception {
        mockMvc.perform(delete("/product/1/delete"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/product"))
                .andExpect(jsonPath("$.size()",is(1)))
                .andExpect(status().isOk());
    }

}