package com.bryanlanghendries.repository.database;

import com.bryanlanghendries.exceptions.EntityNotFoundException;
import com.bryanlanghendries.repository.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DbUserEntityRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}
