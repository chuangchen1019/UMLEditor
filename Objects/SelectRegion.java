package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import Editor.CanvasArea.Canvas;

public class SelectRegion extends Shape {
    private static SelectRegion instance;
    private Rectangle selectRegion;
    private Canvas canvas;

    private SelectRegion() {
        selectRegion = new Rectangle(0, 0, 0, 0);
        canvas = Canvas.getInstance();
        this.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        this.setOpaque(false);
        this.setBackground(Color.BLUE);
    }

    public static synchronized SelectRegion getInstance() {
        if (instance == null) {
            instance = new SelectRegion();
        }
        return instance;
    }
    
    @Override
    public Shape getObjectAt(Point point) {
        return null;
    }

    public void freshRegionBorder(Point initialPoint, Point currentPoint) {
        int x = Math.min(initialPoint.x, currentPoint.x);
        int y = Math.min(initialPoint.y, currentPoint.y);
        int width = Math.abs(currentPoint.x - initialPoint.x);
        int height = Math.abs(currentPoint.y - initialPoint.y);
        selectRegion.setBounds(x, y, width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!selectRegion.isEmpty()) {
            g.setColor(new Color(181, 137, 240, 85));
            g.fillRect(selectRegion.x, selectRegion.y, selectRegion.width, selectRegion.height);
            g.setColor(new Color(181, 137, 240, 85));
            g.drawRect(selectRegion.x, selectRegion.y, selectRegion.width, selectRegion.height);
        }
    }



}
