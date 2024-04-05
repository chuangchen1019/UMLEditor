import javax.swing.*;
import Modes.SelectMode;
import Modes.Mode;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Dimension;
import java.awt.Graphics;

public class Canvas extends JPanel implements MouseListener {
    private Mode currentMode;

    public Canvas() {
        this.currentMode = new SelectMode();
        this.setModeAndListeners(currentMode);
        setPreferredSize(new Dimension(800, 600));
    }

    public void setModeAndListeners(Mode mode) {
        for (MouseListener listener : this.getMouseListeners()) {
            this.removeMouseListener(listener);
        }
        for (MouseMotionListener listener : this.getMouseMotionListeners()) {
            this.removeMouseMotionListener(listener);
        }
        this.addMouseListener(mode);
        this.addMouseMotionListener(mode);
    }

    public Mode getCurrentMode() {
        return this.currentMode;
    }

    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        System.out.println("Canvas click");
	}

	@Override
	public void mousePressed(MouseEvent e) {
        System.out.println("Canvas pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
