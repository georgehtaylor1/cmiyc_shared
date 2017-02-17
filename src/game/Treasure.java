package game;

import java.util.UUID;

import game.constants.GameSettings;
import game.states.TreasureState;
import game.util.Position;

/**
 * @author Denis Makula
 *         Class that contains Treasure Information (state, weight, value, position)
 **/
public class Treasure {

    public Position position;

    public double value;
    public double weight;
    public String id;

    public TreasureState state;

    /**
     * Create a new treasure at the specified coordinates
     *
     * @param _x The x coordinate of the treasure
     * @param _y The y coordinate of the treasure
     */
    public Treasure(double _x, double _y) {
        this(new Position(_x, _y), GameSettings.Treasure.defaultValue, GameSettings.Treasure.defaultWeight);
    }

    /**
     * Create a new treasire at the specified coordinates with a specified value
     *
     * @param _x     The x coordinate of the treasure
     * @param _y     The y coordinate of the treasure
     * @param _value The value of the treasure
     */
    public Treasure(double _x, double _y, int _value) {
        this(new Position(_x, _y), _value, GameSettings.Treasure.defaultWeight);
    }

    /**
     * Create a treasure at a specific position
     *
     * @param _position The position of the treasure
     * @param _value    The value of the treasure
     */
    public Treasure(Position _position, int _value) {
        this(_position, _value, GameSettings.Treasure.defaultWeight);
    }

    /**
     * Create a new treasure with a specified value and weight
     *
     * @param _position The position of the new treasure
     * @param _value    The value of the treasure
     * @param _weight   The weight of the treasure
     */
    public Treasure(Position _position, double _value, double _weight) {
        this.id = UUID.randomUUID().toString();
        this.position = _position;
        this.value = _value;
        this.weight = _weight;
        this.state = TreasureState.UNPICKED;
    }

}
