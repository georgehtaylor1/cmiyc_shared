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
        INIT_CLIENT, UPDATE_CLIENT_STATE, KILL_CONNECTION,

        // Server -> Client
        SUCCESSFULL_CONNECTION, INIT_GAME, UPDATE_ID, REMOVE_PLAYER,

        // Server <-> Client
        ADD_PLAYER, UPDATE_MOVEMENT, UPDATE_PLAYER_STATE, UPDATE_TREASURE_STATE, DEPLOY_CAMERA, UPDATE_THIEF_SCORE;

    }

    /**
     * The keys for objects sent between the client and server
     */
    public static enum Key {

        // Client -> Server
        POSITION, CAMERA, DRAGGED_PLAYER, CLIENT_STATE, CLIENT_USERNAME,

        // Server -> Client
        OBSTACLES, TREASURES, PLAYER_POSITIONS, PLAYER_DIRECTIONS,

        // Server <-> Client
        FACTION, PLAYER_STATE, CLIENT_ID, UNDEFINED, TREASURE_STATE, TREASURE_ID, SCORE;


    }

}
