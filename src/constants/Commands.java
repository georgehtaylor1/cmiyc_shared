package constants;

/**
 * Commands to be sent between the server and client
 */
public class Commands {

    /**
     * Actions sent between the client and server
     */
    public static enum Action {

        // Client -> Server
        UPDATE_USERNAME, UPDATE_CLIENT_STATE, KILL_CONNECTION,

        // Server -> Client
        SUCCESSFULL_CONNECTION, INIT_GAME, UPDATE_ID,

        // Server <-> Client
        UPDATE_MOVEMENT, UPDATE_PLAYER_STATE, UPDATE_TREASURE_STATE, DEPLOY_CAMERA;

    }

    /**
     * The keys for objects sent between the client and server
     */
    public static enum Key {

        // Client -> Server
        DIRECTION, POSITION, CAMERA, DRAGGED_PLAYER, CLIENT_STATE,

        // Server -> Client
        OBSTACLES, TREASURES, PLAYER_POSITIONS, PLAYER_DIRECTIONS,

        // Server <-> Client
        PLAYER_STATE, CLIENT_ID, UNDEFINED, TREASURE_STATE, TREASURE_ID;


    }

}
