package game;

import java.util.UUID;

import game.util.Position;

public class Camera {
	
	String id;
	public Position position;
	public double direction;
	public double length;
	
	public Camera(double x, double y, double dir, double len) {
		this.id = UUID.randomUUID().toString();
		position = new Position(x, y);
		direction = dir;
		length = len;
	}

}
