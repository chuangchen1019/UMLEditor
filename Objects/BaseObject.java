package Objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

public class BaseObject extends Shape {
    protected int portSize;

    public BaseObject(String name) {
        super();
        setOpaque(false);
        this.setName(name);
        this.portSize = 10;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        repaint();
    }

    @Override
    public void addToCanvas(){
        System.out.println("Add object!!");
        super.addToCanvas();
        canvas.addToShapeList(this);
        canvas.printAllShape();
    }

    @Override
    public void removeFromCanvas(){
        super.removeFromCanvas();
        canvas.removeFromShapeList(this);
    }

    @Override
    public Shape getObjectAt(Point point) {
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // refreshLine();
        int portSize = 10;
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (isSelected) {
            // paint connection port
            g2d.fillRect(this.width / 2 - portSize / 2, 0, portSize, portSize);
            g2d.fillRect(0, this.height / 2 - portSize / 2, portSize, portSize);
            g2d.fillRect(this.width / 2 - portSize / 2, this.height - portSize, portSize, portSize);
            g2d.fillRect(this.width - portSize, this.height / 2 - portSize / 2, portSize, portSize);
        }
    }
    
}
