package Editor.CanvasArea;
import javax.swing.*;
import Objects.Shape;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;


public class Canvas extends JPanel {
    private static Canvas canvas;
    protected ArrayList<Shape> shapeList;
    protected JPanel box;

	private Canvas() {
        this.box = new JPanel();
        this.setLayout(new BorderLayout());
        shapeList = new ArrayList<Shape>();
		this.add(box, BorderLayout.CENTER);
        this.box.setLayout(null);
        this.box.setName("Box");
        CanvasListener listener = CanvasListener.getInstance();
        this.box.addMouseListener(listener);
        this.box.addMouseMotionListener(listener);
    }

    public static synchronized Canvas getInstance() {
        if (canvas == null) {
            canvas = new Canvas();
        }
        return canvas;
    }

    public void refresh() {
        this.box.revalidate();
        this.box.repaint();
    }

    public Component add(Component obj) {
        this.box.add(obj, 0);
        refresh();
        return null;
    }

    @Override
    public void remove(Component obj) {
        this.box.remove(obj);
        refresh();
    }

    public void removeWholeObject(Component obj) {
        this.box.remove(obj);
        this.shapeList.remove(obj);
        refresh();
    }

    public void selectFrom(Point ltop, Point rdown) {
        for (Shape obj : this.shapeList) {
            int w = obj.getWidth();
            int h = obj.getHeight();
            Point loc = obj.getLocation();

            boolean up = loc.y > ltop.y;
            boolean left = loc.x > ltop.x;
            boolean down = (loc.y + h) < rdown.y;
            boolean right = (loc.x + w) < rdown.x;

            if (up && left && down && right) {
                obj.select();
            }
        }
    }

    public void unselectAll() {
        for (Shape obj : this.shapeList) {
            obj.unselect();
        }
    }

    public void addToShapeList(Shape obj) {
        this.shapeList.add(obj);
    }

    public void printAllShape() {
        for (Shape obj : this.shapeList) {
            System.out.println("[DEBUG]shapeList: " + obj.getName());
        }
    }

    public void printComponents() {
        System.out.println("Components in Canvas:");
        Component[] components = this.box.getComponents();
        for (Component comp : components) {
            System.out.println("[Debug]: " + comp);
        }
    }

    public void removeFromShapeList(Shape obj) {
        this.shapeList.remove(obj);
    }

    // public Shape getBasicObjectAt(Point point) {
    //     Component component = this.getComponentAt(point.x, point.y);
    //     if (component != null)
    //         return ((Shape) component).getObjectAt(point);
    //     else
    //         return null;
    // }

    @Override
    public Component getComponentAt(int x, int y) {
        System.out.println("x:" + x + " " + " y:" + y);
        Component component = this.box.getComponentAt(x, y);
        if (component == this.box){
            System.out.println("[Debug] No componenets");
            return null;
        }
        else 
            return component;
    }

    // public Point convertPointToCanvas(Component component, Point point) {
    //     return SwingUtilities.convertPoint(component, point, this.box);
    // }

    // public Point convertPointToComponent(Component component, Point point) {
    //     return SwingUtilities.convertPoint(this.box, point, component);
    // }

}
