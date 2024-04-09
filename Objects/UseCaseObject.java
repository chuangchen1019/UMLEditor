package Objects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
        
        int ovalW = width - portSize * 2;
        int ovalH = height - portSize * 2;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.lightGray);
        
        // draw oval
        oval.setFrame(portSize, portSize, ovalW, ovalH);
        g2d.fillOval(portSize, portSize, ovalW, ovalH);;
        g2d.setColor(Color.GRAY);
        g2d.drawOval(portSize, portSize, ovalW - 1, ovalH - 1);

        // get text length
        int textW = g2d.getFontMetrics().stringWidth(this.getName());
        int textH = g2d.getFontMetrics().getHeight();

        // get alignment position
        int x = (width - textW) / 2;
        int y = (height - textH) / 2 + textH - g2d.getFontMetrics().getDescent();
        g2d.drawString(this.getName(), x, y);

    }
    
    @Override
    public boolean contains(int x, int y) {
        return oval.contains(x, y);
    }
}
