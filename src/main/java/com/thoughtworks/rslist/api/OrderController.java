package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import com.thoughtworks.rslist.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated

public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @GetMapping("/order")
    public List<OrderEntity> getAllOrder() {
        return orderService.getAllOrder();
    }

    @DeleteMapping("/order/{index}/delete")
    public ResponseEntity deleteOneOeder(@PathVariable Integer index) {
        orderService.deleteOneOrder(index);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/order/add")
    public ResponseEntity addOrder(@RequestBody Order order) {
        orderService.addOneOrder(order);
        return ResponseEntity.ok().build();
    }

}
