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
		return angle(p1.x, p1.y, p2.x, p2.y);
	}

	/**
	 * Method to get the angle between two points
	 * 
	 * @param p1X
	 *            position 1 X
	 * @param p1Y
	 *            position 1 Y
	 * @param p2X
	 *            position 2 X
	 * @param p2Y
	 *            position 2 Y
	 * @return Angle in radians
	 */
	public static double angle(double p1X, double p1Y, double p2X, double p2Y) {
		if (p1X != p2X && p1Y != p2Y) {
			double xdif = (p2X - p1X);
			double ydif = (p2Y - p1Y);
			double angle = 0; // in radians
			angle = -Math.atan(ydif / xdif);
			if (xdif < 0) {
				if (ydif < 0) {
					angle += Math.PI;
				} else {
					angle -= Math.PI;
				}
			}
			return -angle;
		} else if (p1X > p2X) {
			return Math.PI;
		} else if (p1X < p2X) {
			return 0.0;
		} else if (p1Y > p2Y) {
			return -Math.PI / 2.0;
		} else if (p1Y < p2Y) {
			return Math.PI / 2.0;
		}
		return 0.0;
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
				* (-0.5 * (Math.sin(angle(myPos, soundPos)) + 1));
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
				* (0.5 * (Math.cos(angle(myPos, soundPos)) + 1));
	}

	/**
	 * Get the volume in the left ear
	 * 
	 * @param myPos
	 *            The position of the player to whom the volume applies
	 * @param myName
	 *            The name of the player so that it can be ignored
	 * @param players
	 *            The rest of the players in the game
	 * @return The calculated volume in the left ear
	 */
	public static double getLeftVolume(Position myPos, String myName, ConcurrentHashMap<String, Player> players) {
		double totalVolume = 0;
		Iterator<Entry<String, Player>> i = players.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, Player> e = i.next();
			if (e.getKey() != myName) {
				Player p = e.getValue();
				if (dist(myPos, p.position) < GameSettings.Player.listeningRadius)
					totalVolume += getLeftVolumeProportion(myPos, p.position) * p.volume;
			}
		}
		return totalVolume;
	}

	/**
	 * Get the volume in the right ear
	 * 
	 * @param myPos
	 *            The position of the player to whom the volume applies
	 * @param myName
	 *            The name of the player so that it can be ignored
	 * @param players
	 *            The rest of the players in the game
	 * @return The calculated volume in the right ear
	 */
	public static double getRightVolume(Position myPos, String myName, ConcurrentHashMap<String, Player> players) {
		double totalVolume = 0;
		Iterator<Entry<String, Player>> i = players.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, Player> e = i.next();
			if (e.getKey() != myName) {
				Player p = e.getValue();
				if (dist(myPos, p.position) < GameSettings.Player.listeningRadius)
					totalVolume += getRightVolumeProportion(myPos, p.position) * p.volume;
			}
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
