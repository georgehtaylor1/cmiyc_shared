package game.constants;

import java.awt.Color;
import java.awt.Dimension;

import constants.Colors;
import game.Faction;
import game.GameMode;

/**
 * @author Denis Makula Class full of constants to be used by the game
 **/
public class GameSettings {

	/**
	 * Represents the game screen
	 */
	public static class Screen {
		public final Dimension size = new Dimension(840, 490);
	}

	/**
	 * Represents the fog to be drawn on the screen
	 */
	public static class Fog {
		public final Color color = Colors.fog;
	}

	/**
	 * Represents the arena in which games are played
	 */
	public static class Arena {
		public static Dimension size = new Dimension(800, 450);
		public static Dimension outerSize = new Dimension(840, 490);

		public Color color = Colors.arena;
		public Color outerColor = Colors.outerArena;
	}

	/**
	 * Represents the player in the arena
	 */
	public static final class Player {
		public static final double radius = 10;

		//The radius at which sounds can be heard
		public static final double listeningRadius = 20.0;

		public final Color shadowColor = Colors.playerShadow;

		public final static Faction defaultFaction = Faction.SECURITY;
		public final static GameMode defaultDesiredMode = GameMode.SHORT;
	}

	/**
	 * Represents a security guard in the arena
	 */
	public static final class Security {
		public static final double catchRadius = 15;
		public static final double lightRadius = 70;
		public static final double lightArcPercentage = 13;

		public final Color aliveColor = Colors.activeSecurity;
		public final Color stuckColor = Colors.stuckSecurity;
	}

	/**
	 * Represents a thief in the arena
	 */
	public static final class Thief {
		public static final double stealRadius = 10;
		public static final double visionRadius = 120;

		public final Color color = Colors.activeThief;
	}

	/**
	 * Represents a piece of treasure in the arena
	 */
	public static final class Treasure {
		public static final double defaultValue = 100;
		public static final double defaultWeight = 10;
		public static final double radius = 4;

		public final Color color = Colors.treasure;
		public final Color shadowColor = Colors.treasureShadow;
	}

}
