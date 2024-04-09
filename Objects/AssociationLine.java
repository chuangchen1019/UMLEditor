package Objects;

import java.awt.Graphics2D;
import java.awt.Point;

public class AssociationLine extends LineStyle {

    @Override
    protected void drawTail(Graphics2D g2d, Point head, Point tail) {
    }

    @Override
    protected void drawHead(Graphics2D g2d, Point head, Point tail) {
        double angle = Math.atan2(tail.y - head.y, tail.x - head.x);
        double arrowLength = 12;

        int[] arrow_x = { 
            (int) (tail.x - arrowLength * Math.cos(angle - Math.PI / 6)), tail.x,
            (int) (tail.x - arrowLength * Math.cos(angle + Math.PI / 6)) 
        };
        int[] arrow_y = { 
            (int) (tail.y - arrowLength * Math.sin(angle - Math.PI / 6)), tail.y,
            (int) (tail.y - arrowLength * Math.sin(angle + Math.PI / 6)) 
        };
        // draw arrow
		for (int i = 0; i<2; i++){
			g2d.drawLine(arrow_x[i], arrow_y[i], arrow_x[i+1], arrow_y[i+1]);
		}
    }
    
}
