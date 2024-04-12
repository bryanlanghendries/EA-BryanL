package com.bryanlanghendries.repository.database;

import com.bryanlanghendries.repository.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbUserEntityRepository extends JpaRepository<UserEntity, Integer> {
}
