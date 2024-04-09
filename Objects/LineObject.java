package Objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics;
import java.util.ArrayList;

import Objects.Direction;
import Objects.Shape;

public class LineObject extends Shape {
    protected Point tail;
    protected Point head;
    protected Point tailRelatedToCanvas;
    protected Point headRelatedToCanvas;
    protected Point location;
    protected int padding;
    protected Dimension size;
    protected int lineWidth;
    protected LineStyle line;
    protected ArrayList<Shape> connectShape;

    public LineObject(LineStyle line) {
        super();
        this.connectShape = new ArrayList<Shape>();
        this.line = line;
        this.lineWidth = 2;
        this.padding = 10;
        this.color = Color.BLACK;
        this.setOpaque(false);
    }

    public LineObject(LineStyle line, Point dest, Point src) {
        super();
        this.connectShape = new ArrayList<Shape>();
        this.line = line;
        this.lineWidth = 2;
        this.padding = 5;
        this.color = Color.BLACK;
        this.setOpaque(false);
        updateSizeAndLocation(tail, head);
    }

    @Override
    public Shape getObjectAt(Point point) {
        return null;
    }

    public void updateSizeAndLocation(Point dest, Point src) {
        this.location = getLoc(dest, src);
        this.size = getSizeOfDimension(dest, src);
        
        // Set location related to canvas
        this.tailRelatedToCanvas = dest;
        this.headRelatedToCanvas = src;
        
        // Set location
        this.tail = this.minusPoint(dest, this.location);
        this.head = this.minusPoint(src, this.location);
        this.setSize(this.size);
        this.setLocation(location);
    }

    protected Point getLoc(Point dest, Point src) {
        int x = Math.min(dest.x, src.x) - this.padding;
        int y = Math.min(dest.y, src.y) - this.padding;
        Point location = new Point(x, y);
        return location;
    }

    protected Dimension getSizeOfDimension(Point dest, Point src) {
        Dimension size = new Dimension(Math.abs(dest.x - src.x) + this.padding * 2,
                Math.abs(dest.y - src.y) + this.padding * 2);
        return size;
    }

    protected Point minusPoint(Point a, Point b) {
        return new Point(a.x - b.x, a.y - b.y);
    }

    public void setHeadPoint(Point head) {
        updateSizeAndLocation(this.tailRelatedToCanvas, head);
        repaint();
    }

    public void setTailPoint(Point tail) {
        updateSizeAndLocation(tail, this.headRelatedToCanvas);
        repaint();
    }

    public void setPoint(Point point, boolean direction) {
        if (direction == Direction.TAIL)
            setTailPoint(point);
        else 
            setHeadPoint(point);
    }

    public void connectLineToObject(Shape obj, int port, boolean direction) {
        // Add connection shape to list
        this.connectShape.add(obj);
        // Add line to object port
        obj.addLine(this, port, direction);
    }

    @Override
    public void removeFromCanvas(){
        super.removeFromCanvas();
        for(Shape obj: this.connectShape){
            obj.removeLine(this);
        }
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    protected void draw(Graphics g) {
        this.line.color = this.color;
        this.line.draw(g, tail, head);
    }

}
