package game;

import game.util.Position;

/**
 * @author Denis Makula
 * Class that contains information about the walls / obstacles in game (corners and area)
 **/
public class Obstacle {

	public Position topLeft;
	public Position bottomLeft;
	public Position bottomRight;
	public Position topRight;
	
	public double width;
	public double height;
	
	public Obstacle( int _x, int _y, int _width, int _height ) {
		this( new Position( _x, _y ), new Position( _x, ( _y + _height ) ), new Position( ( _x + _width ), ( _y + _height ) ), new Position( ( _x + _width ), _y ) );
	}
	
	public Obstacle( Position _topLeft, Position _bottomLeft, Position _bottomRight, Position _topRight ) {
		this.topLeft = _topLeft;
		this.bottomLeft = _bottomLeft;
		this.bottomRight = _bottomRight;
		this.topRight = _topRight;
		this.width = this.topRight.x - this.topLeft.x;
		this.height = this.bottomRight.y - this.topRight.y;
	}
	
}
