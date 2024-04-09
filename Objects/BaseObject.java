package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Iterator;
import Editor.EditorFrame;
import Editor.PopupDialog;

public class BaseObject extends Shape {
    protected int portSize;
    protected ArrayList<ArrayList<LinePair>> linePairList;
    // Direction : up / left / down / right

    public BaseObject(String name) {
        super();
        setOpaque(false);
        this.setName(name);
        this.portSize = 10;
        this.linePairList = new ArrayList<ArrayList<LinePair>>();
        for (int i = 0; i < 4; i++) {
            this.linePairList.add(new ArrayList<LinePair>());
            this.linePairList.set(i, new ArrayList<LinePair>());
        }
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        repaint();
    }

    @Override
    public void addToCanvas(){
        System.out.println("Add object!!");
        super.addToCanvas();
        canvas.addToShapeList(this);
        canvas.printAllShape();
    }

    @Override
    public void removeFromCanvas(){
        super.removeFromCanvas();
        canvas.removeFromShapeList(this);
    }

    @Override
    public Shape getObject(Point point) {
        return this;
    }

    @Override
    public Point getPortLocation(int direction) {
        Point portLoc = null;
        if (direction == Direction.UP)
            // UP
            portLoc = new Point(this.width/2, portSize);
        else if (direction == Direction.LEFT)
            // LEFT
            portLoc = new Point(portSize, this.height/2);
        else if (direction == Direction.DOWN)
            // DOWN
            portLoc = new Point(this.width/2, this.height-portSize);
        else if (direction == Direction.RIGHT)
            // RIGHT
            portLoc = new Point(this.width - portSize, this.height/2);
        
        return canvas.convertPointToCanvas(this, portLoc);
    }

    @Override
    public int getPortDirection(Point point) {
        // 判斷 point 是屬於哪一個 port
        point = canvas.convertPointToComponent(this, point);
        
        // 使用斜率為 -1 的直線來判斷點在直線的哪一側
        Point port = new Point(
            (-1 * ((float) height/width) * point.x + height - point.y) > 0 ? 1 : 0 // 1:左上 0:右下
            , ((float) height / width * point.x - point.y) > 0 ? 1 : 0);           // 1:右上 0:左下

        int ret = port.x * 2 + port.y;

        if (ret == 0) return Direction.DOWN;
        else if (ret == 1) return Direction.RIGHT;
        else if (ret == 2) return Direction.LEFT;
        else if (ret == 3) return Direction.UP;
        
        return Direction.OUTSIDE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        refreshLine();
        int portSize = 10;
        int offset = portSize - 5;
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (isSelected) {
            // paint connection port
            g2d.setColor(new Color(181, 137, 240));
            g2d.fillRect(this.width/2 - offset/2, offset, offset, offset);
            g2d.fillRect(offset, this.height/2 - offset/2, offset, offset);
            g2d.fillRect(this.width/2 - offset/2, this.height - portSize, offset, offset);
            g2d.fillRect(this.width - portSize, this.height/2 - offset/2, offset, offset);
        }
    }
    
    private class LinePair {
        public LineObject line;
        public boolean lineDirection; // Arrow direction

        public LinePair(LineObject line, boolean lineDirection) {
            this.line = line;
            this.lineDirection = lineDirection;
        }
    }

    @Override
    public void addLine(LineObject line, int direction, boolean lineDirection) {
        this.linePairList.get(direction).add(new LinePair(line, lineDirection));
    }

    @Override
    public void removeLine(LineObject line){
        for (ArrayList<LinePair> pairsList : linePairList) {
            Iterator<LinePair> it = pairsList.iterator();
            // Find target line and remove
            while (it.hasNext()) {
                LinePair linePairs = it.next();
                if (linePairs.line == line) {
                    it.remove();
                    break;
                }
            }
        }
    }

    // Update connection pos between object and line
    private void refreshLine() {
        for (int i = 0; i < 4; i++) {
            for (LinePair pair : linePairList.get(i)) {
                Point point = getPortLocation(i);
                if (pair.lineDirection == Direction.TAIL) {
                    pair.line.setTailPoint(point);
                } else pair.line.setHeadPoint(point);
            }
        }
    }

    @Override
    public void changeName() {
        PopupDialog dialog = new PopupDialog(EditorFrame.getInstance());
        if (dialog.isConfirm()) {
            String nameString = dialog.getName();
            this.setName(nameString);
        }
    }
}
