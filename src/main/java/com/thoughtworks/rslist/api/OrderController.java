package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
        List<OrderEntity> orderEntity =  orderRepository.findAll();
        System.out.println(orderEntity.size());
        return orderEntity;
    }

    @DeleteMapping("/product/{index}/delete")
    public ResponseEntity deleteOneOeder(@PathVariable Integer index){
        orderRepository.deleteById(index);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/product/add")
    public ResponseEntity addOrder(@RequestBody Order order){
        System.out.println(order.getName());
        OrderEntity orderEntity = OrderEntity.builder()
                .name(order.getName())
                .price(order.getPrice())
                .num(order.getNum())
                .unit(order.getUnit())
                .build();
        orderRepository.save(orderEntity);
        return ResponseEntity.ok().build();
    }

}
