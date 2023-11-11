package com.example.codeclan.subwaysamurai.subwaysamurai.repository;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyRepository extends JpaRepository<Enemy, Long> {

}
