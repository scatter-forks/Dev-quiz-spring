package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import com.thoughtworks.rslist.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import static com.thoughtworks.rslist.utiles.HttpClientUtils.httpConnectionGET;
import static com.thoughtworks.rslist.utiles.HttpClientUtils.httpURLConnectionPOST;

@RestController
@CrossOrigin

public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
//        OrderEntity orderEntity1 = OrderEntity.builder()
//                .name("可乐")
//                .price(3)
//                .num(3)
//                .unit("瓶")
//                .build();
//        OrderEntity orderEntity2 = OrderEntity.builder()
//                .name("雪碧")
//                .price(3)
//                .num(5)
//                .unit("瓶")
//                .build();
//        orderRepository.save(orderEntity1);
//        orderRepository.save(orderEntity2);
    }


    @GetMapping("/order")
    public List<OrderEntity> getAllOrder() {//List<OrderEntity>
        return orderService.getAllOrder();
    }

    @DeleteMapping("/order/{index}/delete")
    public ResponseEntity deleteOneOrder(@PathVariable Integer index) {
        orderService.deleteOneOrder(index);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "order/add")
    public ResponseEntity addOrder(@RequestBody Order order) throws UnsupportedEncodingException {
        orderService.addOneOrder(order);
        return ResponseEntity.ok().build();
    }

}
