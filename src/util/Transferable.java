package util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import constants.Commands;
import constants.Commands.Action;
import constants.Commands.Key;

public class Transferable implements Serializable {

	private static final long serialVersionUID = -617995930063793718L;
	
	public Transferable() { this.object = new HashMap<Key, Object>(); }

	public Transferable( Action _action ) { this.action = _action; this.object = new HashMap<Key, Object>(); }

	public Transferable( Action _action, Object _object ) {
		this.action = _action;
		this.object = new HashMap<Key, Object>();
		this.object.put( Key.UNDEFINED , _object );
	}

	public Transferable( Action _action, HashMap<Key, Object> _objects ) {
		this.action = _action;
		this.object = new HashMap<Key, Object>( _objects );
	}

	public Action action;
	public HashMap<Key, Object> object;

}
