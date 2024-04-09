package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ClassObject extends BaseObject {
    private Rectangle rect;
    
    public ClassObject() {
        super("Class");
        this.rect = new Rectangle();
        this.width = 80;
        this.height = 90;
        this.setSize(this.width, this.height);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // System.out.println("Class object paint");
        super.paintComponent(g);
        this.setSize(this.width, this.height);
        
        Graphics2D g2d = (Graphics2D) g;
        int rectwidth = width - portSize * 2;
        int rectheight = height - portSize * 2;
        
        g2d.setColor(Color.LIGHT_GRAY);
        
        // draw rectangle
        rect.setFrame(portSize, portSize, rectwidth, rectheight);
        g2d.fill(rect);
        g2d.setColor(Color.GRAY);
        g2d.drawRect(portSize, portSize, rectwidth - 1, rectheight - 1);
        
        // draw lines
        g2d.drawLine(portSize, rectheight / 3 + portSize, width - portSize - 1,
                rectheight / 3 + portSize);
        g2d.drawLine(portSize, (rectheight / 3) * 2 + portSize, width - portSize - 1,
                (rectheight / 3) * 2 + portSize);

        // get text length
        int textWidth = g2d.getFontMetrics().stringWidth(this.getName());
        int textHeight = g2d.getFontMetrics().getHeight();

        // get alignment position
        int x = (width - textWidth) / 2;
        int y = (rectheight / 3 - textHeight)/2+portSize+textHeight-g2d.getFontMetrics().getDescent();
        g2d.drawString(this.getName(), x, y);
    }
    
    @Override
    public boolean contains(int x, int y) {
        return rect.contains(x, y);
    }
}
