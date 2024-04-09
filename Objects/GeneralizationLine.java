package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class GeneralizationLine extends LineStyle {

    @Override
    protected void drawHead(Graphics2D g2d, Point head, Point tail) {
        double arrowLength = 12;
        double angle = Math.atan2(tail.y - head.y, tail.x - head.x);

        // 定義箭頭的形狀
        int[] arrow_x = {
            (int) (tail.x - arrowLength * Math.cos(angle - Math.PI / 4)), tail.x,
            (int) (tail.x - arrowLength * Math.cos(angle + Math.PI / 4))
        };

        int[] arrow_y = {
            (int) (tail.y - arrowLength * Math.sin(angle - Math.PI / 4)), tail.y,
            (int) (tail.y - arrowLength * Math.sin(angle + Math.PI / 4))
        };

        // 繪製填充的箭頭
        g2d.setColor(Color.WHITE);
        g2d.fillPolygon(arrow_x, arrow_y, 3);

        // 繪製邊框的箭頭
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(arrow_x, arrow_y, 3);
    }
}
