package util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import constants.Commands;
import constants.Commands.Action;
import constants.Commands.Key;

public class Transferable implements Serializable {

    private static final long serialVersionUID = -617995930063793718L;

    /**
     * Create a new transferable object
     */
    public Transferable() {
        this.object = new HashMap<Key, Object>();
    }

    /**
     * Create a new transferable object with a specified action
     * @param _action The action specified by the transferable object
     */
    public Transferable(Action _action) {
        this.action = _action;
        this.object = new HashMap<Key, Object>();
    }

    /**
     * Create a transferable object, specifying the action and data
     * @param _action Specify the action for the object
     * @param _object Specify the object data to be sent
     */
    public Transferable(Action _action, Object _object) {
        this.action = _action;
        this.object = new HashMap<Key, Object>();
        this.object.put(Key.UNDEFINED, _object);
    }

    /**
     * Create a transferable object specifying the action and a collection of data
     * @param _action
     * @param _objects
     */
    public Transferable(Action _action, HashMap<Key, Object> _objects) {
        this.action = _action;
        this.object = new HashMap<Key, Object>(_objects);
    }

    public Action action;
    public HashMap<Key, Object> object;

}
