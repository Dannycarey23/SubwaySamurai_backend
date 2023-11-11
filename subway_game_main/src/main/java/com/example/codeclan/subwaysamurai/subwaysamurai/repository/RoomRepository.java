package com.example.codeclan.subwaysamurai.subwaysamurai.repository;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
