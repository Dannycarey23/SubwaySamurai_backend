package com.example.codeclan.subwaysamurai.subwaysamurai.controller;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.Player;
import com.example.codeclan.subwaysamurai.subwaysamurai.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping(value="/players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping(value="/players/{id}")
    public ResponseEntity getPlayer (@PathVariable Long id){
        return new ResponseEntity<>(playerRepository.findById(id), HttpStatus.OK);

    }

    @PutMapping(value = "/players/{id}")
    public Player updatePlayer(@RequestBody Player updatedPlayer, @PathVariable Long id){
        Player currentPlayer = (Player) playerRepository.findById(id).get();
        currentPlayer.setName(updatedPlayer.getName());
        currentPlayer.setHealth(100);
        currentPlayer.setAttackPoints(25);
        playerRepository.save(currentPlayer);
        return currentPlayer;
    }
}
