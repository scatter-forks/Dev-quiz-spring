package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class OrderController {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderController(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public List<OrderEntity> addOneOrder(){
        System.out.println("=======华丽的分割线=======");
        List<OrderEntity> orderEntity =  orderRepository.findAll();
        System.out.println(orderEntity.size());
        return orderEntity;
    }

}
