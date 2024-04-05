import java.awt.*;
import javax.swing.*;

import Modes.AssociationMode;
import Modes.ClassMode;
import Modes.CompositionMode;
import Modes.GeneralizationMode;
import Modes.SelectMode;
import Modes.UsecaseMode;

public class UMLEditor extends JFrame {
    private Canvas canvas;
    private JPanel toolPanel;
    
    private JButton selectButton;
    private JButton associationButton;
    private JButton generalizationButton;
    private JButton compositionButton;
    private JButton classButton;
    private JButton useCaseButton;

    public UMLEditor() {
        setTitle("UML Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        toolPanel = new JPanel();
        canvas = new Canvas();

        toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
        int buttonWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 6);
        
        selectButton = createButton("select", buttonWidth);
        associationButton = createButton("association", buttonWidth);
        generalizationButton = createButton("generalization", buttonWidth);
        compositionButton = createButton("composition", buttonWidth);
        classButton = createButton("class", buttonWidth);
        useCaseButton = createButton("use case", buttonWidth);

        toolPanel.add(selectButton);
        toolPanel.add(associationButton);
        toolPanel.add(generalizationButton);
        toolPanel.add(compositionButton);
        toolPanel.add(classButton);
        toolPanel.add(useCaseButton);
        
        add(toolPanel, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        selectButton.addActionListener(e -> {
            System.out.println("selectButton");
            SelectMode selectMode = new SelectMode();
            canvas.setModeAndListeners(selectMode);
        });

        associationButton.addActionListener(e -> {
            System.out.println("associationButton");
            AssociationMode associationMode = new AssociationMode();
            canvas.setModeAndListeners(associationMode);
        });

        generalizationButton.addActionListener(e -> {
            System.out.println("generalizationButton");
            GeneralizationMode generalizationMode = new GeneralizationMode();
            canvas.setModeAndListeners(generalizationMode);
        });

        compositionButton.addActionListener(e -> {
            System.out.println("generalizationButton");
            CompositionMode compositionMode = new CompositionMode();
            canvas.setModeAndListeners(compositionMode);
        });

        classButton.addActionListener(e -> {
            System.out.println("classButton");
            ClassMode classMode = new ClassMode();
            canvas.setModeAndListeners(classMode);
        });

        useCaseButton.addActionListener(e -> {
            System.out.println("useCaseButton");
            UsecaseMode usecaseMode = new UsecaseMode();
            canvas.setModeAndListeners(usecaseMode);
        });
    }

    private static JButton createButton(String text, int size) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(size, size));
        return button;
    }
}
