package Modes.object;
import Objects.Shape;
import java.awt.event.MouseEvent;

import Modes.Mode;

public abstract class CreateObjectMode extends Mode {

    public CreateObjectMode() {
        super();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Create ObjectMode click");
        super.mouseClicked(e);
        Shape object = createObject();
        object.setLocation(clickPoint);
        System.out.println("Click | " + clickPoint.x + " " + clickPoint.y);
        object.addToCanvas();
        canvas.printComponents();
    }
    protected abstract Shape createObject();
}
