package Modes;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import Objects.SelectRegion;
import Objects.Shape;

public class SelectionMode extends Mode {
    private Shape pressedComponent = null;  
    private Point offset = null;
  
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
            if (!obj.isSelected()) obj.select();
        } else canvas.unselectAll();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Component component = canvas.getComponentAt(pressPoint.x, pressPoint.y);
        if (component != null) {
            pressedComponent = (Shape) component;
            Point location = pressedComponent.getLocation();
            offset = new Point(location.x - pressPoint.x, location.y - pressPoint.y);
        }else{
            canvas.add(SelectRegion.getInstance());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        pressedComponent = null;
        if (isDragged) {
            isDragged = false;
            canvas.unselectAll();
            Point leftTop = new Point(
                Math.min(pressPoint.x, releasePoint.x),
                Math.min(pressPoint.y, releasePoint.y)
            );
            Point rightDown = new Point(
                Math.max(pressPoint.x, releasePoint.x),
                Math.max(pressPoint.y, releasePoint.y)
            );
            // When mouse release -> perform select
            canvas.selectFrom(leftTop, rightDown);
        }
        canvas.cleanSelectRegion();
        
        // Remove selection window
        canvas.remove(SelectRegion.getInstance());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (pressedComponent != null) {
            // Update component postion for drag move
            System.out.println(pressedComponent.getName() + " x: " + (e.getX()+offset.x) + ", y: " + (e.getY()+offset.y));
            pressedComponent.setLocation(e.getX() + offset.x, e.getY() + offset.y);
        }
        else canvas.setSelectRegion(pressPoint, e.getPoint());
    }
}
