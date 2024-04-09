package Objects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class UseCaseObject extends BaseObject {
    private Ellipse2D oval;
    
    public UseCaseObject() {
        super("Use Case");
        this.oval = new Ellipse2D.Double();
        this.setName(this.getName());
        this.width = 120;
        this.height = 70;
        this.setSize(this.width, this.height);
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        // System.out.println("Use Case object paint");
        super.paintComponent(g);
        this.setSize(this.width, this.height);
        
        Graphics2D g2d = (Graphics2D) g;
        int ovalwidth = width - portSize * 3;
        int ovalheight = height - portSize * 2;
        
        g.drawOval(portSize, portSize, ovalwidth, ovalheight);
        g2d.setColor(Color.LIGHT_GRAY);
        
        // draw oval
        g2d.fillOval(portSize, portSize, ovalwidth, ovalheight);;
        g2d.setColor(Color.GRAY);

        // get text length
        int textWidth = g2d.getFontMetrics().stringWidth(this.getName());
        int textHeight = g2d.getFontMetrics().getHeight();

        // get alignment position
        int x = (width - textWidth) / 2;
        int y = (height - textHeight) / 2 + textHeight - g2d.getFontMetrics().getDescent();
        g2d.drawString(this.getName(), x, y);

    }
    
    @Override
    public boolean contains(int x, int y) {
        return oval.contains(x, y);
    }
    
}
