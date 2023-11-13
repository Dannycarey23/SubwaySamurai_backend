package com.example.codeclan.subwaysamurai.subwaysamurai.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "healthItems")
public class HealthItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "healthPoints")
    private int healthPoints;

    @JsonIgnoreProperties({"healthItems"})
    @ManyToOne
    @JoinColumn(name = "players_id", nullable = false)
    private Player player;

    public HealthItem(String itemName, int healthPoints) {
        this.itemName = itemName;
        this.healthPoints = healthPoints;
    }

    public HealthItem( ) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
