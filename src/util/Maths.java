package util;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import game.Player;
import game.constants.GameSettings;
import game.util.Position;

/**
 * A class to contain mathematical helper functions
 * 
 * @author george
 *
 */
public class Maths {

	private static double[] sin = new double[360];

	/**
	 * Initialise the array of sine values
	 */
	public static void initTrigApproximations() {
		for (int i = 0; i < 360; i++) {
			sin[i] = Math.sin(i);
		}
	}

	/**
	 * Get the approximate sine value for the given angle
	 * 
	 * @param angle
	 *            The angle to find the sine value of
	 * @return The approximate result of applying sine to the value
	 */
	public static double approxSin(int angle) {
		return sin[Math.floorMod(angle, 360)];
	}

	/**
	 * Get the approximate cosine value for the given angle
	 * 
	 * @param angle
	 *            The angle to find the cosine value of
	 * @return The approximate result of applying cosine to the value
	 */
	public static double approxCos(int angle) {
		return approxSin(angle + 90);
	}

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
	public static double getLeftVolumeProportion(Position myPos, Position soundPos) {
		double listeningRadius = GameSettings.Player.listeningRadius;
		return ((listeningRadius - dist(myPos, soundPos)) / listeningRadius)
				* (-0.5 * (approxCos((int) angle(myPos, soundPos)) + 1));
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
	public static double getRightVolumeProportion(Position myPos, Position soundPos) {
		double listeningRadius = GameSettings.Player.listeningRadius;
		return ((listeningRadius - dist(myPos, soundPos)) / listeningRadius)
				* (0.5 * (approxCos((int) angle(myPos, soundPos)) + 1));
	}

	/**
	 * Get the volume in the left ear
	 * 
	 * @param myPos
	 *            The position of the player to whom the volume applies
	 * @param players
	 *            The rest of the players in the game
	 * @return The calculated volume in the left ear
	 */
	public static double getLeftVolume(Position myPos, ConcurrentHashMap<String, Player> players) {
		double totalVolume = 0;
		Iterator<Entry<String, Player>> i = players.entrySet().iterator();
		while (i.hasNext()) {
			Player p = i.next().getValue();
			if (dist(myPos, p.position) < GameSettings.Player.listeningRadius)
				totalVolume += getLeftVolumeProportion(myPos, p.position) * p.volume;
		}
		return totalVolume;
	}

	/**
	 * Get the volume in the right ear
	 * 
	 * @param myPos
	 *            The position of the player to whom the volume applies
	 * @param players
	 *            The rest of the players in the game
	 * @return The calculated volume in the right ear
	 */
	public static double getRightVolume(Position myPos, ConcurrentHashMap<String, Player> players) {
		double totalVolume = 0;
		Iterator<Entry<String, Player>> i = players.entrySet().iterator();
		while (i.hasNext()) {
			Player p = i.next().getValue();
			if (dist(myPos, p.position) < GameSettings.Player.listeningRadius)
				totalVolume += getRightVolumeProportion(myPos, p.position) * p.volume;
		}
		return totalVolume;
	}

	/**
	 * Get the position dictated by the projection of the given position over distance d at angle a
	 * 
	 * @param p
	 *            The position to be projected from
	 * @param d
	 *            The distance of the projection
	 * @param a
	 *            The angle of the projection
	 * @return The position of the projected image
	 */
	public static Position project(Position p, double d, double a) {
		return new Position(p.x + (Math.cos(a) * d), p.y + (Math.sin(a) * d));
	}

}
