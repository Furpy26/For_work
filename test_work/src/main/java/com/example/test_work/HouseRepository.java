package com.example.test_work;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
    List<House> findByOwner(User owner);
}
