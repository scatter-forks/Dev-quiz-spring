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
import java.util.Optional;

@RestController
@Validated
public class OrderController {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderController(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @GetMapping("/order")
    public List<OrderEntity> addOneOrder() {
        List<OrderEntity> orderEntity = orderRepository.findAll();
        System.out.println(orderEntity.size());
        return orderEntity;
    }

    @DeleteMapping("/order/{index}/delete")
    public ResponseEntity deleteOneOeder(@PathVariable Integer index) {
        orderRepository.deleteById(index);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/order/add")
    public ResponseEntity addOrder(@RequestBody Order order) {
        // 如果商品已经在订单列表中 再次添加只会添加商品数量
        OrderEntity orderEntity;
        List<OrderEntity> temp = orderRepository.findByName(order.getName());
        if (temp.size() == 0) {
            orderEntity = OrderEntity.builder()
                    .name(order.getName())
                    .price(order.getPrice())
                    .num(order.getNum())
                    .unit(order.getUnit())
                    .build();
        }else {
            orderEntity = temp.get(0);
            Integer orginNum = orderEntity.getNum();
            orderEntity.setNum(orginNum+order.getNum());
        }
        orderRepository.save(orderEntity);
        return ResponseEntity.ok().build();
    }

}
