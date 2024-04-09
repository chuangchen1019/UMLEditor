package Modes.line;

import Objects.GeneralizationLine;
import Objects.LineObject;

public class GeneralizationMode extends LineMode {
    public GeneralizationMode(){
        super();
    }

    @Override
    public LineObject newLine(){
        return new LineObject(new GeneralizationLine());
    }
}
