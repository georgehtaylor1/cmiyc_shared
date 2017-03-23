package game.util;

import java.io.Serializable;

public class Movement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -500213403997987660L;

	public String clientID;
	
	public Position position;
	public double direction;
	public double battery;
	
	public Movement( String _clientID, Position _position, double _direction, double _battery ) {
		this.clientID = _clientID;
		this.position = _position;
		this.direction = _direction;
		this.battery = _battery;
	}
	
}
