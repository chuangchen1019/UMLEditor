package Modes.line;

import Objects.AssociationLine;
import Objects.LineObject;

public class AssociationMode extends LineMode {
    public AssociationMode(){
        super();
    }

    @Override
    public LineObject newLine(){
        return new LineObject(new AssociationLine());
    }
}
