package com.example.codeclan.subwaysamurai.subwaysamurai.repository;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Long> {

}
