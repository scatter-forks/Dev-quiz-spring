package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAll();

    @Transactional
    @Query(value = "select * from list where name = ?1", nativeQuery = true)
    List<OrderEntity> findByName(String name);
}
