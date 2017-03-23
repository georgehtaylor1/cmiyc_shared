package game.util;

import java.io.Serializable;

import game.constants.GameSettings;
import util.Maths;

/**
 * @author Denis Makula Position Class (this is just an x/y wrapper, which should be translated into Point or Point2D after it has been transfered, unpacked and
 *         unserialised)
 **/
public class Position implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6384488353385200357L;
	public double x = 0;
	public double y = 0;

	/**
	 * Create a new position in the centre of the screen
	 */
	public Position() {
		this((GameSettings.Arena.size.width / 2), (GameSettings.Arena.size.height / 2));
	}

	/**
	 * Create a new position at the specified x an y coordinates
	 * 
	 * @param _x
	 *            The x coordinate of the new position
	 * @param _y
	 *            The y coordinate of the new position
	 */
	public Position(double _x, double _y) {
		this.x = _x;
		this.y = _y;
	}

	/**
	 * Determine whether this position is the same as the given position, This is a necessary function in order to eliminate floating point errors that could
	 * occur if equality was used to compare two positions
	 * 
	 * @param p
	 *            The position to compare to
	 * @return Whehter the position being compared to is the same
	 */
	public boolean at(Position p, double threshold) {
		return Maths.dist(this, p) < threshold;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object p) {
		return this.x == ((Position) p).x && this.y == ((Position) p).y;
	}

}
