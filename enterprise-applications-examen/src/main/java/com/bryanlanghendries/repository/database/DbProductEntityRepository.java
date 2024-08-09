package com.bryanlanghendries.repository.database;

import com.bryanlanghendries.enums.ProductCategory;
import com.bryanlanghendries.repository.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbProductEntityRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategory(ProductCategory category);
}
