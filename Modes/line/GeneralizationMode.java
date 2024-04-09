package Modes.line;

import Objects.AssociationLine;
import Objects.LineObject;

public class GeneralizationMode extends LineMode {
    public GeneralizationMode(){
        super();
    }

    @Override
    public LineObject newLine(){
        return new LineObject(new AssociationLine());
    }
}
