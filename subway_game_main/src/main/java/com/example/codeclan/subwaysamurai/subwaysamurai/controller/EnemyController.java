package com.example.codeclan.subwaysamurai.subwaysamurai.controller;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.Enemy;
import com.example.codeclan.subwaysamurai.subwaysamurai.repository.EnemyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnemyController {

    @Autowired
    EnemyRepository enemyRepository;

    @GetMapping(value = "/enemies")
    public List<Enemy> getAllEnemies(){
        return enemyRepository.findAll();
    }

    @GetMapping(value = "/enemies/{id}")
    public ResponseEntity getEnemy (@PathVariable Long id){
        return new ResponseEntity<>(enemyRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/enemies/{id}")
    public Enemy updateEnemy(@RequestBody Enemy updatedEnemy, @PathVariable Long id){
        Enemy currentEnemy = (Enemy) enemyRepository.findById(id).get();
        currentEnemy.setName(updatedEnemy.getName());
        currentEnemy.setHealth(updatedEnemy.getHealth());
        currentEnemy.setAttackPoints(updatedEnemy.getAttackPoints());
        enemyRepository.save(updatedEnemy);
        return currentEnemy;
    }
}
