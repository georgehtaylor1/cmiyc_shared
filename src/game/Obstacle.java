package game;

import game.util.Position;
import util.Maths;

/**
 * @author Denis Makula Class that contains information about the walls / obstacles in game (corners and area)
 **/
public class Obstacle {

	public Position topLeft;
	public Position bottomLeft;
	public Position bottomRight;
	public Position topRight;

	public double width;
	public double height;

	/**
	 * Create a new obstacle
	 *
	 * @param _x
	 *            The x-coordinate of the top left of the obstacle
	 * @param _y
	 *            The y-coordinate of the top right of the obstacle
	 * @param _width
	 *            The width of the obstacle
	 * @param _height
	 *            The height of the obstacle
	 */
	public Obstacle(int _x, int _y, int _width, int _height) {
		this(new Position(_x, _y), new Position(_x, (_y + _height)), new Position((_x + _width), (_y + _height)),
				new Position((_x + _width), _y));
	}

	/**
	 * Creates a new obstacle
	 *
	 * @param _topLeft
	 *            The position of the top left of the obstacle
	 * @param _bottomLeft
	 *            The position of the bottom left of the obstacle
	 * @param _bottomRight
	 *            The position of the bottom right of the obstacle
	 * @param _topRight
	 *            The position of the top right of the obstacle
	 */
	public Obstacle(Position _topLeft, Position _bottomLeft, Position _bottomRight, Position _topRight) {
		this.topLeft = _topLeft;
		this.bottomLeft = _bottomLeft;
		this.bottomRight = _bottomRight;
		this.topRight = _topRight;
		this.width = this.topRight.x - this.topLeft.x;
		this.height = this.bottomRight.y - this.topRight.y;
	}

	/**
	 * Does the given obstacle contain this position
	 * 
	 * @param p
	 *            The position to be checked
	 * @return A boolean indicating whether the position is inside the obstacle
	 */
	public boolean contains(Position p) {
		return p.x > topLeft.x && p.x < topRight.x && p.y >= topLeft.y && p.y <= bottomLeft.y;
	}

}
