package com.example.codeclan.subwaysamurai.subwaysamurai.models;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name="enemies")
public class Enemy {

    @Column(name = "names")
    private String name;
    @Column(name = "health")
    private int health;

    @Column(name = "attackPoints")
    private int attackPoints;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    public Enemy(String name, int health, int attackPoints){
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
    }

    public Enemy(){

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


    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void attack(Player player){
        Random random = new Random();
        int attackDamage = random.nextInt(10) + this.attackPoints;
        player.setHealth(player.getHealth() - attackDamage);
    }
}
