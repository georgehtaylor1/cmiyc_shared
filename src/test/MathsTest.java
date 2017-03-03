package test;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Player;
import game.util.Position;
import util.Maths;

public class MathsTest {

	static Position[] pos = new Position[6];
	static ConcurrentHashMap<String, Player> chmPlayers;
	static Player p1, p2, p3, p4, p5;

	/**
	 * Set up the objects to be used in the tests
	 */
	@BeforeClass
	public static void setUp() {

		pos[0] = new Position(3, 3);
		pos[1] = new Position(0, 0);
		pos[2] = new Position(0, 1);
		pos[3] = new Position(1, 0);
		pos[4] = new Position(1, 1);
		pos[5] = new Position(2, 1);

		p1 = new Player("test1");
		p2 = new Player("test2");
		p3 = new Player("test3");
		p4 = new Player("test4");
		p5 = new Player("test5");

		chmPlayers = new ConcurrentHashMap<String, Player>();
		chmPlayers.put("key1", p1);
		chmPlayers.put("key2", p2);
		chmPlayers.put("key3", p3);
		chmPlayers.put("key4", p4);
		chmPlayers.put("key5", p5);
	}

	@AfterClass
	public static void tearDown() {

	}

	/**
	 * Test the distance function
	 */
	@Test
	public void testDist() {
		Assert.assertEquals(1.0000, Maths.dist(pos[1], pos[2]), 0.01);
		Assert.assertEquals(1.0000, Maths.dist(pos[1], pos[3]), 0.01);
		Assert.assertEquals(1.4142, Maths.dist(pos[2], pos[3]), 0.01);
		Assert.assertEquals(2.2361, Maths.dist(pos[1], pos[5]), 0.01);
		Assert.assertEquals(2.0000, Maths.dist(pos[2], pos[5]), 0.01);
	}

	/**
	 * Test the angle function
	 */
	@Test
	public void testAngle() {
		Assert.assertEquals(Math.PI / 2, Maths.angle(pos[1], pos[2]), 0.1);
		Assert.assertEquals(0, Maths.angle(pos[1], pos[3]), 0.1);
		Assert.assertEquals(Math.PI / 4, Maths.angle(pos[1], pos[4]), 0.1);
		Assert.assertEquals(0, Maths.angle(pos[2], pos[5]), 0.1);
		Assert.assertEquals(0.4636, Maths.angle(pos[1], pos[5]), 0.1);
	}

	/**
	 * Test the functions that calculate the proportion of volume in the left and right ear
	 */
	@Test
	public void testVolumeProportions() {

		Assert.assertEquals(0, Maths.getLeftVolumeProportion(pos[1], pos[2]), 0.01);

	}

}
