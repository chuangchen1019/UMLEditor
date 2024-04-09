package Editor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Editor.CanvasArea.Canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorMenu extends JMenuBar {
    private Canvas canvas;  

    public EditorMenu() {
        super();
        this.canvas = canvas.getInstance();
        JMenu editMenu = new JMenu("Edit");
        JMenuItem groupItem = new JMenuItem("Group");
        JMenuItem ungroupItem = new JMenuItem("Ungroup");
        JMenuItem renameItem = new JMenuItem("Rename");
        JMenuItem deleteItem = new JMenuItem("Delete");

        groupItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Group Item clicked");
                canvas.groupSelectedObjects();
            }
        });

        ungroupItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Group Item clicked");
                canvas.ungroupSelectedObjects();
            }
        });

        renameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("rename item");
                canvas.changeObjectName();
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete item");
            }
        });

        editMenu.add(groupItem);
        editMenu.add(ungroupItem);
        editMenu.add(renameItem);
        editMenu.add(deleteItem);

        this.add(editMenu);
    }
    
}
