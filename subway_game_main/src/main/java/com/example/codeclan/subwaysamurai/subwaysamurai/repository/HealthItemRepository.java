package com.example.codeclan.subwaysamurai.subwaysamurai.repository;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.HealthItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthItemRepository extends JpaRepository<HealthItem, Long> {
}
