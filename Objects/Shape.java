package Objects;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;
import Editor.CanvasArea.Canvas;

public abstract class Shape extends JPanel {
    protected int x, y, width, height;
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
    
    public void addToCanvas() {
        canvas.add(this);
    }

    public void removeFromCanvas() {
        canvas.remove(this);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public abstract Shape getObjectAt(Point point);

}
