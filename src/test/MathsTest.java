package test;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import game.Player;
import game.util.Position;
import util.Maths;

public class MathsTest {

	Position pos1, pos2, pos3, pos4, pos5;
	ConcurrentHashMap<String, Player> chmPlayers;
	Player p1, p2, p3, p4, p5;

	public void setUp() {

		Maths.initTrigApproximations();

		pos1 = new Position(0, 0);
		pos2 = new Position(0, 1);
		pos3 = new Position(1, 0);
		pos4 = new Position(1, 1);
		pos5 = new Position(2, 1);

		p1 = new Player("test1");
		p2 = new Player("test2");
		p3 = new Player("test3");
		p4 = new Player("test4");
		p5 = new Player("test5");

		chmPlayers.put("key1", p1);
		chmPlayers.put("key2", p2);
		chmPlayers.put("key3", p3);
		chmPlayers.put("key4", p4);
		chmPlayers.put("key5", p5);
	}

	public void tearDown() {

	}

	@Test
	public void test() {

	}

	private void testDist() {

	}

}
