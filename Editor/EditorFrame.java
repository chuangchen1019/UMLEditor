package Editor;
import java.awt.*;
import Editor.CanvasArea.Canvas;
import Editor.ModeArea.ToolPanel;

import javax.swing.*;


public class EditorFrame extends JFrame {
    private static EditorFrame instance;
    private static String title = "UML Editor";

    public EditorFrame() {
        super(title);
        System.out.println("Editor Frame Initialization");
        EditorMenu editorMenu = new EditorMenu();
        this.setJMenuBar(editorMenu);

        Canvas canvas = Canvas.getInstance();
        JPanel toolPanel = ToolPanel.getInstance();

        setLayout(new BorderLayout());
        
        // add(editorMenu, BorderLayout.NORTH);
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
            System.out.println("No Editor Frame instance exist, create one");
            instance = new EditorFrame();
        }
        return instance;
    }
}
