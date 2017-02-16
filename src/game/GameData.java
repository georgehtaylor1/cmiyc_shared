package game;

import java.util.ArrayList;
import java.util.HashMap;

import constants.Commands.Key;
import game.states.GameState;
import game.util.Position;

public class GameData {
	
	public GameState state;
	public GameMode mode;
	
	public ArrayList<Player> players;
	public ArrayList<Treasure> treasures;
	public ArrayList<Obstacle> obstacles;
	public ArrayList<Camera> cameras;
	
	public GameData() {
		this.state = GameState.OFFLINE;
		
		this.players = new ArrayList<Player>();
		this.treasures = new ArrayList<Treasure>();
		this.obstacles = new ArrayList<Obstacle>();
		this.cameras = new ArrayList<Camera>();
	}
	
	public boolean fits( Player _player ) {
		
		if( this.state != GameState.PREGAME ) { return false; }
		
		Player player = _player;
		
		int maxPlayerCount = ( this.mode == GameMode.SHORT ) ? 3 : 5;
		int limitPerFaction = ( ( this.mode == GameMode.SHORT ) ) ? ( ( player.faction == Faction.THIEF ) ? 1 : 2 ) : ( ( player.faction == Faction.THIEF ) ? 2 : 3 );
		
		if( this.players.size() == maxPlayerCount ) { return false; }
		else if( this.mode != player.mode ) { return false; }
		else if( this.players.size() == 0 ) { return true; }
		else {
			int existingPerFaction = 0;
			ArrayList<Player> tempPlayers = new ArrayList<Player>( this.players );
			
			for( Player connectedPlayer : tempPlayers ) {
				if( connectedPlayer.faction == player.faction ) { existingPerFaction++; }
			}
						
			return ( existingPerFaction < limitPerFaction );
		}
		
	}

}
