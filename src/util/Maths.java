package util;

import game.util.Position;

/**
 * A class to contain mathematical helper functions
 * 
 * @author george
 *
 */
public class Maths {

	/**
	 * Get the Euclidian distance between two objects
	 * 
	 * @param p1
	 *            The first point
	 * @param p2
	 *            The second point
	 * @return The distance between the points
	 */
	public static double dist(Position p1, Position p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

}
