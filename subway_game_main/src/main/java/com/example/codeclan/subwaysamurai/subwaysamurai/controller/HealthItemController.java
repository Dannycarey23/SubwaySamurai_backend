package com.example.codeclan.subwaysamurai.subwaysamurai.controller;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.HealthItem;
import com.example.codeclan.subwaysamurai.subwaysamurai.repository.HealthItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HealthItemController {
    @Autowired
    HealthItemRepository healthItemRepository;

    @GetMapping(value = "/healthItems")
    public List<HealthItem> getAllHealthItems(){
        return healthItemRepository.findAll();
    }

    @GetMapping(value = "/healthItems/{id}")
    public ResponseEntity getHealthItem(@PathVariable Long id){
        return new ResponseEntity<>(healthItemRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/healthItems/{id}")
    public HealthItem updateHealthItem(@RequestBody HealthItem updatedHealthItem, @PathVariable Long id){
        HealthItem currentHealthItem = (HealthItem) healthItemRepository.findById(id).get();
        currentHealthItem.setHealthPoints(updatedHealthItem.getHealthPoints());
        currentHealthItem.setItemName(updatedHealthItem.getItemName());
        healthItemRepository.save(updatedHealthItem);
        return currentHealthItem;
    }
}
