package Editor.ModeArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Editor.CanvasArea.Canvas;
import Modes.ModeManager;


public class ToolPanel extends JPanel {
    static JPanel toolPanel;
    private ModeButton[] buttons;
    
    public ToolPanel() {
        toolPanel = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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

    private ImageIcon getIcon(String filename) {
        ImageIcon icon = new ImageIcon("Images/" + filename + ".png");
        int buttonIconSize = 50;

        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();

        double widthRatio = (double) buttonIconSize / originalWidth;
        double heightRatio = (double) buttonIconSize / originalHeight;
        double ratio = Math.min(widthRatio, heightRatio);

        int scaledWidth = (int) (originalWidth * ratio);
        int scaledHeight = (int) (originalHeight * ratio);

        Image scaledImage = icon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        icon.setImage(scaledImage);
        return icon;
    }


        
}
