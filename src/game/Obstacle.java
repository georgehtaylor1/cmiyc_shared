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

	/**
	 * Get the position of the closest corner of the obstacle to the given position, offset by 45 degrees in the specified distance
	 * 
	 * @param p
	 *            The position to be compared to
	 * @param offset
	 *            The offset to be adde to the position of the corner
	 * @return The position of the offset from the closest corner
	 */
	public Position closestCornerOffset(Position p, double offset) {
		Position minPos = closestCorner(p);

		if (minPos.equals(this.topLeft)) {
			return new Position(minPos.x - (offset * Math.cos(Math.PI / 4)),
					minPos.y - (offset * Math.sin(Math.PI / 4)));
		}

		if (minPos.equals(this.bottomLeft)) {
			return new Position(minPos.x - (offset * Math.cos(Math.PI / 4)),
					minPos.y + (offset * Math.sin(Math.PI / 4)));
		}

		if (minPos.equals(this.topRight)) {
			return new Position(minPos.x + (offset * Math.cos(Math.PI / 4)),
					minPos.y - (offset * Math.sin(Math.PI / 4)));
		}

		return new Position(minPos.x + (offset * Math.cos(Math.PI / 4)), minPos.y + (offset * Math.sin(Math.PI / 4)));

	}

	/**
	 * Get the closest corner of the obstacle to the given position
	 * 
	 * @param p
	 *            The position to compare to
	 * @return The position of the closest corner to the position
	 */
	public Position closestCorner(Position p) {
		Position minPos = this.topLeft;
		double minDist = Maths.dist(p, this.topLeft);

		double blDist = Maths.dist(p, this.bottomLeft);
		double trDist = Maths.dist(p, this.topRight);
		double brDist = Maths.dist(p, this.bottomRight);

		if (blDist < minDist) {
			minDist = blDist;
			minPos = this.bottomLeft;
		}

		if (trDist < minDist) {
			minDist = trDist;
			minPos = this.topRight;
		}

		if (brDist < minDist) {
			minDist = brDist;
			minPos = this.bottomRight;
		}

		return minPos;
	}

}
