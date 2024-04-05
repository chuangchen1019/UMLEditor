package Modes;
import java.awt.event.MouseEvent;

public class SelectMode extends Mode{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked in select mode");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed in select mode");
    }
}
