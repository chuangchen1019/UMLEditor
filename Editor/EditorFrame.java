package Editor;
import java.awt.*;
import Editor.CanvasArea.Canvas;
import Editor.ModeArea.ToolPanel;

import javax.swing.*;


public class EditorFrame extends JFrame {
    private static EditorFrame instance;
    private static String title = "UML Editor";

    public EditorFrame() {
        setTitle(title);
        Canvas canvas = Canvas.getInstance();
        JPanel toolPanel = ToolPanel.getInstance();
        EditorMenu editorMenu = new EditorMenu();

        setLayout(new BorderLayout());
        
        add(editorMenu, BorderLayout.NORTH);
        add(toolPanel, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        pack();
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static synchronized EditorFrame getInstance() {
        if (instance == null) {
            instance = new EditorFrame();
        }
        return instance;
    }
}
