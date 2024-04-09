package Editor.ModeArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.JPanel;

import Editor.CanvasArea.Canvas;
import Modes.ModeManager;


public class ToolPanel extends JPanel {
    static JPanel toolPanel;
    private ModeButton[] buttons;
    
    public ToolPanel() {
        toolPanel = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        toolPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButtons();
        // set default selection mode
        buttons[0].doClick();
    }

    public static synchronized JPanel getInstance() {
        return (toolPanel == null)? new ToolPanel(): toolPanel;
    }

    private void addButtons() {
        buttons = new ModeButton[ModeManager.getNumberOfModes()];
        ActionListener actionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentMode = ModeManager.getMode();
                buttons[currentMode].unselect();
                ModeButton button = (ModeButton) e.getSource();
                button.select();
                button.setMode();
                Canvas.getInstance().unselectAll();
            }
        };
        MouseListener mouseListener = new MouseAdapter(){};

        for (int i = 0; i < ModeManager.getNumberOfModes(); i++) {
            ImageIcon icon = getIcon(ModeManager.getModeName(i));
            ModeButton button = new ModeButton(i, icon, actionListener, mouseListener);
            buttons[i] = button;
            this.add(button);
            // Create vertical padding
            if (i < ModeManager.getNumberOfModes() - 1) {
                this.add(Box.createVerticalStrut(2));
            }
        }
    }

    private ImageIcon getIcon(String file) {
        ImageIcon icon = new ImageIcon("Images/" + file + ".png");
        int buttonIconSize = 50;

        int originW = icon.getIconWidth();
        int originH = icon.getIconHeight();

        double wRatio = (double) buttonIconSize / originW;
        double hRatio = (double) buttonIconSize / originH;
        double ratio = Math.min(wRatio, hRatio);

        int scaledW = (int) (originW * ratio);
        int scaledH = (int) (originH * ratio);

        Image scaledImage = icon.getImage().getScaledInstance(scaledW, scaledH, Image.SCALE_SMOOTH);
        icon.setImage(scaledImage);
        return icon;
    }


        
}
