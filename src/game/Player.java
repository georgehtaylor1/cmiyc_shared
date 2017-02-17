package game;

import java.io.Serializable;

import game.constants.GameSettings;
import game.states.PlayerState;
import game.util.Position;

public class Player implements Serializable {

    private static final long serialVersionUID = -6117845925839528271L;

    public String clientID;

    public double speed;
    public double battery;

    public Position position;
    public double direction;

    public Faction faction;
    public GameMode mode;

    public PlayerState state;
    public String dragging;

    /**
     * Create a new player with the specified client ID
     *
     * @param _clientID The ID of the client whom the player represents
     */
    public Player(String _clientID) {
        this.clientID = _clientID;

        this.speed = 1.5;
        this.battery = 1;
        this.direction = 0.0;
        this.position = new Position();
        this.faction = GameSettings.Player.defaultFaction;

        this.mode = GameSettings.Player.defaultDesiredMode;
    }

}
