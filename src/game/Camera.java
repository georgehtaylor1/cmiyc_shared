package game;

import game.util.Position;

import java.util.UUID;

public class Camera {

    String id;
    public Position position;
    public double direction;
    public double length;

    /**
     * Create a new camera
     *
     * @param x   The x position of the camera
     * @param y   The y position of the camera
     * @param dir The direction of the camera
     * @param len The length of the camera
     */
    public Camera(double x, double y, double dir, double len) {
        this.id = UUID.randomUUID().toString();
        position = new Position(x, y);
        direction = dir;
        length = len;
    }

}
