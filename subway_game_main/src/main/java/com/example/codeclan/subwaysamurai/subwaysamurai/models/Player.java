package com.example.codeclan.subwaysamurai.subwaysamurai.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name="players")
public class Player {

    @Column(name = "name")
    private String name;
    @Column(name="health")
    private int health;

    @Column(name = "attackPoints")
    private int attackPoints;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HealthItem> inventory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    public Player(String name, int health, int attackPoints){
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.inventory = new ArrayList<>();
    }

    public Player(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void attack(Enemy enemy){
        Random random = new Random();
        int attackDamage = random.nextInt(15) ;
        enemy.setHealth(enemy.getHealth() - attackDamage);
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public List<HealthItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<HealthItem> inventory) {
        this.inventory = inventory;
    }

    public void addHealthItem(HealthItem healthItem){
        this.inventory.add(healthItem);
        healthItem.setPlayer(this);
    }

    public void removeHealthItem(HealthItem healthItem){
        if(healthItem.getPlayer() != this){
            System.out.println("Not for you >:/");
        } else {
            inventory.remove(healthItem);
            healthItem.setPlayer(null);
        };
    }


}
