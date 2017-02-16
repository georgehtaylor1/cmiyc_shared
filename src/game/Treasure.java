package game;

import java.util.UUID;

import game.constants.GameSettings;
import game.states.TreasureState;
import game.util.Position;

/**
 * @author Denis Makula
 * Class that contains Treasure Information (state, weight, value, position)
 **/
public class Treasure {

	public Position position;
	
	public double value;
	public double weight;
	public String id;
	
	public TreasureState state;
	
	public Treasure( double _x, double _y ) { this( new Position( _x, _y ), GameSettings.Treasure.defaultValue, GameSettings.Treasure.defaultWeight ); }
	
	public Treasure( double _x, double _y, int _value ) { this( new Position( _x, _y ), _value, GameSettings.Treasure.defaultWeight ); }

	public Treasure( Position _position, int _value ) { this( _position, _value, GameSettings.Treasure.defaultWeight ); }
	
	public Treasure( Position _position, double _value, double _weight ) {
		this.id = UUID.randomUUID().toString();
		this.position = _position;
		this.value = _value;
		this.weight = _weight;
		this.state = TreasureState.UNPICKED;
	}

}
