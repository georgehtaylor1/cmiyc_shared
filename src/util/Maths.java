package util;

import game.constants.GameSettings;
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

	/**
	 * Get the angle between two points
	 * 
	 * @param p1
	 *            The first point
	 * @param p2
	 *            The second point
	 * @return The angle between the points
	 */
	public static double angle(Position p1, Position p2) {
		return Math.atan((p1.y - p2.y) / (p1.x - p2.x));
	}

	/**
	 * Get the proportion of the volume of sound in the left ear
	 * 
	 * @param myPos
	 *            The position of the player
	 * @param soundPos
	 *            The position of the sound
	 * @return The proportion of the volume of the sound in the left ear, between 0 and 1
	 */
	public static double getLeftVolume(Position myPos, Position soundPos) {
		double listeningRadius = GameSettings.Player.listeningRadius;
		return ((listeningRadius - dist(myPos, soundPos)) / listeningRadius)
				* (-0.5 * (Math.cos(angle(myPos, soundPos)) + 1));
	}

	/**
	 * Get the proportion of the volume of sound in the right ear
	 * 
	 * @param myPos
	 *            The position of the player
	 * @param soundPos
	 *            The position of the sound
	 * @return The proportion of the volume of the sound in the right ear, between 0 and 1
	 */
	public static double getRightVolume(Position myPos, Position soundPos) {
		double listeningRadius = GameSettings.Player.listeningRadius;
		return ((listeningRadius - dist(myPos, soundPos)) / listeningRadius)
				* (0.5 * (Math.cos(angle(myPos, soundPos)) + 1));
	}

}
