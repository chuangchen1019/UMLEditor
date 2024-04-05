package Objects;
import java.awt.*;

public class ClassObject extends BaseObject {
    private String className;

    public ClassObject(int x, int y, int width, int height, Color color, String className) {
        super(x, y, width, height, color);
        this.className = className;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawString(className, x + 10, y + 20);
    }
}
