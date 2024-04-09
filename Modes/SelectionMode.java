package Modes;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import Objects.Shape;

public class SelectionMode extends Mode {
    public SelectionMode() {
        super();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Component component = canvas.getComponentAt(clickPoint.x, clickPoint.y);
        canvas.printComponents();

        if (component != null) {
            Shape obj = (Shape) component;
            canvas.unselectAll();
            if (!obj.isSelected()) {
                System.out.println("[D]]");
                obj.select();
            }
        } else {
            System.out.print("Get no component");
            canvas.unselectAll();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Component component = canvas.getComponentAt(pressPoint.x, pressPoint.y);
        if (component != null) {
            
        }else{
        }
    }
}
