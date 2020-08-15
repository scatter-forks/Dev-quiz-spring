package com.thoughtworks.rslist.repository;

        import com.thoughtworks.rslist.entity.OrderEntity;
        import com.thoughtworks.rslist.entity.ProductEntity;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;

        import javax.transaction.Transactional;
        import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();

    @Transactional
    @Query(value = "select * from product where name = ?1", nativeQuery = true)
    List<ProductEntity> findByName(String name);
}
