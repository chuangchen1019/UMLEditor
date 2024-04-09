package Objects;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class CompositeObject extends Shape {
    protected ArrayList<Shape> group;

    public CompositeObject(ArrayList<Shape> objects) {
        super();
        this.group = objects;
        System.out.println("CompositeObject Position: (" + getX() + ", " + getY() + ")");

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Shape obj : objects) {
            Point location = obj.getLocation();
            minX = Math.min(minX, location.x);
            minY = Math.min(minY, location.y);
            maxX = Math.max(maxX, location.x + obj.getWidth());
            maxY = Math.max(maxY, location.y + obj.getHeight());
        }

        int width = maxX - minX;
        int height = maxY - minY;
        setLocation(minX, minY);
        setSize(width, height);
        setLayout(null);
        setOpaque(false);
        System.out.println("CompositeObject Position: (" + getX() + ", " + getY() + ")");

        addObjects();
    }

    public void addToGroup(Shape obj) {
        group.add(obj);
    }

    @Override
    public void ungroup() {
        for (Shape shape : this.group) {
            Point pin = shape.getLocation();
            shape.setLocation(pin.x + getX(), pin.y + getY());
            shape.unselect();
            shape.addToCanvas();
        }
        canvas.removeWholeObject(this);
    }

    public void clearGroup() {
        group.clear();
    }

    @Override
    public Shape getObject(Point point) {
        Point pt = SwingUtilities.convertPoint(this.getParent(), point, this);
        Shape obj = (Shape) this.getComponentAt(pt.x, pt.y);
        if (obj != null) return obj.getObject(pt);
        return null;
    }

    protected void addObjects() {
        for (Shape shape : this.group) {
            Point pin = shape.getLocation();
            System.out.println("Shape Position: (" + pin.x + ", " + pin.y + ")");
            shape.setLocation(pin.x - getX(), pin.y - getY());
            add(shape, 0);
        }
        System.out.println("CompositeObject Position After Adding Shapes: (" + getX() + ", " + getY() + ")");
    }

    public void printAllCompositeObject() {
        for (Shape obj : this.group) {
            System.out.println(obj);
        }
    }

    @Override
    public void addToCanvas(){
        super.addToCanvas();
        canvas.addToShapeList(this);
    }

    @Override
    public void select() {
        for (Shape shape : this.group) {
            shape.select();
        }
        super.select();
    }

    @Override
    public void unselect() {
        for (Shape shape : this.group) {
            shape.unselect();
        }
        super.unselect();
    }

}
