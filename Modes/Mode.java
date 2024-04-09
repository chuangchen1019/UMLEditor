package Modes;
import java.awt.Point;
import java.awt.event.MouseEvent;
import Editor.CanvasArea.*;

public abstract class Mode {
    protected Canvas canvas;
    protected Point pressPoint;
    protected Point releasePoint;
    protected Point clickPoint;
    protected boolean isDragged;

    public Mode() {
        canvas = Canvas.getInstance();
        pressPoint = null;
        releasePoint = null;
        clickPoint = null;
        isDragged = false;
    }

    public void mouseClicked(MouseEvent e) {
        // System.out.println("Mode: mouse clicked");
        clickPoint = e.getPoint();
    }

    public void mousePressed(MouseEvent e) {
        // System.out.println("Mode: mouse pressed");
        pressPoint = e.getPoint();
    }

    public void mouseReleased(MouseEvent e) {
        // System.out.println("Mode: mouse released");
        releasePoint = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
        // System.out.println("Mode: mouse dragged");
        isDragged = true;
    }
}
