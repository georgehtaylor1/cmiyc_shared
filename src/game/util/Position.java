package game.util;

import game.constants.GameSettings;

/**
 * @author Denis Makula
 * Position Class (this is just an x/y wrapper, which should be translated into Point or Point2D after it has been transfered, unpacked and unserialised)
 **/
public class Position {

	public double x = 0;
	public double y = 0;
	
	public Position() { this( ( GameSettings.Arena.size.width / 2 ), ( GameSettings.Arena.size.height / 2 ) ); }
	
	public Position( double _x, double _y ) { this.x = _x;this.y = _y; }
	
}
