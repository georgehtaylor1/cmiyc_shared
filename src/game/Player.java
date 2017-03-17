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
	public int cameras;
	
	public Position position;
	public double direction;

	public Faction faction;
	public GameMode mode;

	public PlayerState state;

	public double volume;

	/**
	 * Create a new player with the specified client ID
	 *
	 * @param _clientID
	 *            The ID of the client whom the player represents
	 */
	public Player(String _clientID) {
		this.clientID = _clientID;

		this.speed = 1.5;
		this.battery = 1;
		this.cameras = 2;
		this.direction = 0.0;
		this.position = new Position();
		this.volume = 1.0;
		this.faction = GameSettings.Player.defaultFaction;
		this.state = PlayerState.NORMAL;

		this.mode = GameSettings.Player.defaultDesiredMode;
	}

}
