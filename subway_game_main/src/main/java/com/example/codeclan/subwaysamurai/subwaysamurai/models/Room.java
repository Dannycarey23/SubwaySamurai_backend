package com.example.codeclan.subwaysamurai.subwaysamurai.models;

import javax.persistence.*;

@Entity
@Table(name="rooms")
public class Room {

    @Column(name = "enemys")
    private String enemy;

    @Column(name="room_names")
    private String room_name;

    @Column(name= "players")
    private String player;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Room(String enemy, String room_name, String player){
        this.enemy = enemy;
        this.room_name = room_name;
        this.player = player;

    }

    public Room(){

    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
}
