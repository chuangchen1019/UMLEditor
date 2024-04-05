package Modes;
import java.awt.event.MouseEvent;

public class CompositionMode extends Mode {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked in Composition Mode");
    }
}