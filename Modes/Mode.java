package Modes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Mode extends MouseAdapter{
    // public abstract void handleCanvasClick(MouseEvent event);
    public abstract void mouseClicked(MouseEvent e);
}
