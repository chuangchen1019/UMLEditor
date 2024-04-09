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
    public Point getPortLocation(int direction) {
        Point portLocation = null;
        if (direction == Direction.UP) {
            // UP
            portLocation = new Point(this.width/2, portSize);
        } else if (direction == Direction.LEFT) {
            // LEFT
            portLocation = new Point(portSize, this.height/2);
        } else if (direction == Direction.DOWN) {
            // DOWN
            portLocation = new Point(this.width/2, this.height-portSize);
        } else if (direction == Direction.RIGHT) {
            // RIGHT
            portLocation = new Point(this.width - portSize, this.height/2);
        }
        return canvas.convertPointToCanvas(this, portLocation);
    }

    @Override
    public int getPortDirection(Point point) {
        point = canvas.convertPointToComponent(this, point);
        
        // 使用斜率為 -1 的直線來判斷點在直線的哪一側
        Point port = new Point(
            (-1 * ((float) height/width) * point.x + height - point.y) > 0 ? 1 : 0 // 1:左上 0:右下
            , ((float) height / width * point.x - point.y) > 0 ? 1 : 0);           // 1:右上 0:左下

        int result = port.x * 2 + port.y;

        switch (result) {
            case 0:
                return Direction.DOWN;
            case 1:
                return Direction.RIGHT;
            case 2:
                return Direction.LEFT;
            case 3:
                return Direction.UP;
        }

        return Direction.OUTSIDE;
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
