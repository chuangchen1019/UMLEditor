package Editor;
import java.awt.*;
import Editor.CanvasArea.Canvas;
import Editor.ModeArea.ToolPanel;

import javax.swing.*;


public class EditorFrame extends JFrame {
    private static String title = "UML Editor";

    public EditorFrame() {
        setTitle(title);
        Canvas canvas = Canvas.getInstance();
        JPanel toolPanel = ToolPanel.getInstance();

        setLayout(new BorderLayout());

        add(toolPanel, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        pack();
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
