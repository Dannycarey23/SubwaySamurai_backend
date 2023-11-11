package com.example.codeclan.subwaysamurai.subwaysamurai;

import com.example.codeclan.subwaysamurai.subwaysamurai.models.Enemy;
import com.example.codeclan.subwaysamurai.subwaysamurai.models.Player;
import com.example.codeclan.subwaysamurai.subwaysamurai.repository.EnemyRepository;
import com.example.codeclan.subwaysamurai.subwaysamurai.repository.PlayerRepository;
import com.example.codeclan.subwaysamurai.subwaysamurai.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

//@RunWith(SpringRunner.class)
//@ActiveProfiles("test")
@SpringBootTest
public class SubwaysamuraiApplicationTests {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	EnemyRepository enemyRepository;

	@Autowired
	RoomRepository roomRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createPlayer(){
		Player jen = new Player("Jen Jen", 100);
		playerRepository.save(jen);
	}

	@Test
	public void playerCanAttack(){
		Player player = new Player("Emma", 100);
		Enemy enemy = new Enemy("Lord Provost", 50, 10);
		player.attack(enemy);
		assertNotEquals(50, enemy.getHealth());
	}

	@Test
	public void enemyCanAttack(){
		Player player = new Player("Emma", 100);
		Enemy enemy = new Enemy("Lord Provost", 50, 10);
		enemy.attack(player);
		assertNotEquals(100, player.getHealth());
	}

}
