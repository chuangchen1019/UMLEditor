package Modes.object;

import Objects.ClassObject;
import Objects.Shape;

public class ClassMode extends CreateObjectMode {
    public ClassMode() {
        super();
    };

    @Override
    protected Shape createObject(){
        return new ClassObject();
    }
}
