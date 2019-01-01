package com.devson.pagination.web.repository;

import com.devson.pagination.web.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
