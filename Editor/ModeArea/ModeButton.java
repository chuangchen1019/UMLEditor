package Editor.ModeArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

import Modes.ModeManager;

public class ModeButton extends JButton {
    private int mode;
    private int size;

    public ModeButton(int i, ImageIcon icon, ActionListener actionListener, MouseListener mouseListener) {
        super();
        this.mode = i;
        this.setIcon(icon);
        this.size = 80;
        this.addActionListener(actionListener);
        this.addMouseListener(mouseListener);
        this.setAllSize(size);
        this.setBackground(Color.WHITE);
        this.customButtonUI();
    }

    public void setMode() {
        System.out.println(this.mode);
        ModeManager.setMode(this.mode);
    }

    public void select() {
        this.setBackground(Color.GRAY);

    }

    public void unselect() {
        setBackground(Color.WHITE);
    }

    private void customButtonUI() {
        this.setUI(new BasicButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(Color.GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
    }

    private void setAllSize(int size) {
        this.setMinimumSize(new Dimension(size, size));
        this.setMaximumSize(new Dimension(size, size));
    }
}
