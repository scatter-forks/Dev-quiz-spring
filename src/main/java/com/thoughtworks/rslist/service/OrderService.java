package com.thoughtworks.rslist.service;

import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAllOrder() {
        List<OrderEntity> orderEntity = orderRepository.findAll();
        return orderEntity;
    }

    public void deleteOneOrder(Integer index){
        orderRepository.deleteById(index);
    }

    public void addOneOrder(Order order){
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
    }

}
