package game.util;

public class Movement {

	public String clientID;
	public Position position;
	public double direction;
	
	public Movement( String _clientID, Position _position, double _direction ) {
		this.clientID = _clientID;
		this.position = _position;
		this.direction = _direction;
	}
	
}
