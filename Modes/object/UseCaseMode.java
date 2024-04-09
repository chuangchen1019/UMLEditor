package Modes.object;

import Objects.ClassObject;
import Objects.Shape;
import Objects.UseCaseObject;

public class UseCaseMode extends CreateObjectMode {

    public UseCaseMode() {
        super();
    };

    @Override
    protected Shape createObject(){
        return new UseCaseObject();
    }
    
}
