package Modes.line;

import Objects.CompositionLine;
import Objects.LineObject;

public class CompositionMode extends LineMode {
    public CompositionMode(){
        super();
    }

    @Override
    public LineObject newLine(){
        return new LineObject(new CompositionLine());
    }
}
