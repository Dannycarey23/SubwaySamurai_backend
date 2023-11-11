package com.example.codeclan.subwaysamurai.subwaysamurai.controller;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.Player;
import com.example.codeclan.subwaysamurai.subwaysamurai.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Player> getPlayer(@PathVariable Long id){
        return playerRepository.findById(id);
    }

    @PutMapping(value = "/players/{id}")
    public Player updatePlayer(@RequestBody Player updatedPlayer, @PathVariable Long id) {
        Player currentPlayer = playerRepository.findById(id).get();
        currentPlayer.setName(updatedPlayer.getName());
        currentPlayer.setHealth(updatedPlayer.getHealth());
        playerRepository.save(updatedPlayer);
        return currentPlayer;}
}
