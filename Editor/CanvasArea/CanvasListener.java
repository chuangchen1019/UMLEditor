package Editor.CanvasArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Modes.Mode;

public class CanvasListener extends MouseAdapter {
    private static CanvasListener instance;
    private Mode mode;
    
    private CanvasListener(){}
    
    public static synchronized CanvasListener getInstance() {
        if (instance == null) {
            instance = new CanvasListener();
        }
        return instance;
    }

    public void setMode(Mode mode) {
        if (mode == null) {
            System.out.println("gann mode is null");
        }else {
            System.out.println("has modedd");
            this.mode = mode;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mode.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (mode != null) {
            mode.mousePressed(e);
        } else {
            System.out.println("Error: mode is null");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Canvas: mouse released");
        mode.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // System.out.println("Canvas: mouse dragged");
        mode.mouseDragged(e);
    }
}
