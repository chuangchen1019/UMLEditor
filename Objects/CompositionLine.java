package Objects;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class CompositionLine extends LineStyle {
    @Override
    protected void drawHead(Graphics2D g2d, Point head, Point tail) {
        double angle = Math.atan2(tail.y - head.y, tail.x - head.x);
        double arrowLength = 12;

        int[] arrow_x = { (int) Math.round(tail.x - arrowLength * Math.cos(angle - Math.PI / 4)),
            tail.x,
            (int) Math.round(tail.x - arrowLength * Math.cos(angle + Math.PI / 4)),
            (int) Math.round(tail.x - arrowLength * (Math.cos(angle - Math.PI / 4) + Math.cos(angle + Math.PI / 4))) };
        
        int[] arrow_y = { (int) Math.round(tail.y - arrowLength * Math.sin(angle - Math.PI / 4)),
            tail.y,
            (int) Math.round(tail.y - arrowLength * Math.sin(angle + Math.PI / 4)),
            (int) Math.round(tail.y - arrowLength * (Math.sin(angle - Math.PI / 4) + Math.sin(angle + Math.PI / 4))) };

        // draw polygon
        g2d.setColor(Color.WHITE);
        g2d.fillPolygon(new Polygon(arrow_x, arrow_y, 4));
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(new Polygon(arrow_x, arrow_y, 4));
        }    
}
