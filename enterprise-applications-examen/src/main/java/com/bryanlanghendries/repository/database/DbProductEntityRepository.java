package com.bryanlanghendries.repository.database;

import com.bryanlanghendries.repository.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbProductEntityRepository extends JpaRepository<ProductEntity, Integer> {
}
