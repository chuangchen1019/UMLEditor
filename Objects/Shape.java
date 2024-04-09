package Objects;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JPanel;
import Editor.CanvasArea.Canvas;

public abstract class Shape extends JPanel {
    protected int width;
    protected int height;
    protected Color color;
    protected boolean isSelected;
    protected Canvas canvas;

    public Shape() {
        canvas = Canvas.getInstance();
        isSelected = false;
    }

    public void select() {
        isSelected = true;
        revalidate();
        repaint();
    }

    public void unselect() {
        isSelected = false;
        revalidate();
        repaint();
    }

    public void toggleSelect() {
        if (isSelected()) {
            unselect();
        } else {
            select();
        }
    }

    public boolean isSelected() {
        return isSelected;
    }
    
    public void addToCanvas() {
        canvas.add(this);
    }

    public void removeFromCanvas() {
        canvas.remove(this);
    }
    // Line object operation
    public void addLine(LineObject line, int direction, boolean lineDirection) {}
    public void removeLine(LineObject line) {}

    // Update selected object's size and location with current position
    public void freshRegionBorder(Point initialPoint, Point currentPoint) {}

    // Get the the point of specify port
    public Point getPortLocation(int direction) { return null; }
    // Get the Direction code of port
    public int getPortDirection(Point point) { return -1; }

    // Basic object op
    public abstract Shape getObject(Point point);
    public void changeName() {}
    public void ungroup() {}
    
}
