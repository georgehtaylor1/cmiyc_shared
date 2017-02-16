package constants;

public class Commands {

	public static enum Action {
		
		// Client -> Server
		UPDATE_USERNAME, START_DRAG, STOP_DRAG, UPDATE_CLIENT_STATE, KILL_CONNECTION,
		
		// Server -> Client
		SUCCESSFULL_CONNECTION, INIT_GAME,
		
		// Server <-> Client
		UPDATE_MOVEMENT, UPDATE_PLAYER_STATE, UPDATE_TREASURE_STATE, DEPLOY_CAMERA;
		
	}
	
	public static enum Key { 
		
		// Client -> Server
		DIRECTION, POSITION, CAMERA, DRAGGED_PLAYER, CLIENT_STATE,
		
		// Server -> Client
		OBSTACLES, TREASURES, PLAYER_POSITIONS, PLAYER_DIRECTIONS,
		
		// Server <-> Client
		PLAYER_STATE, CLIENT_ID, UNDEFINED, TREASURE_STATE, TREASURE_ID;
		
		
	}
	
}
