package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    void setUp() {
        OrderEntity orderEntity1 = OrderEntity.builder()
                .name("可乐")
                .price(3)
                .num(3)
                .unit("瓶")
                .build();
        OrderEntity orderEntity2 = OrderEntity.builder()
                .name("可乐")
                .price(3)
                .num(5)
                .unit("瓶")
                .build();
        orderRepository.save(orderEntity1);
        orderRepository.save(orderEntity2);
    }


    @GetMapping("/product")
    public List<OrderEntity> addOneOrder(){
//        setUp();
        List<OrderEntity> orderEntity =  orderRepository.findAll();
        System.out.println(orderEntity.size());
        return orderEntity;
    }

    @DeleteMapping("/product/{index}/delete")
    public ResponseEntity deleteOneOeder(@PathVariable Integer index){
        setUp();
        orderRepository.deleteById(index);
        return ResponseEntity.ok().build();

    }

}
