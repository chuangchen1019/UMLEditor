package Modes.line;
import java.awt.Point;
import java.awt.event.MouseEvent;
import Objects.Shape;
import Objects.LineObject;
import Objects.Direction;
import Modes.Mode;

public abstract class LineMode extends Mode {
    private LineObject line = null;
    private Shape pressObject = null;
    private int pressPort;
    private boolean connectToPort = false;

    public LineMode() {
        super();
    }

    protected abstract LineObject newLine();

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (line == null) {
            pressObject = canvas.getBaseObjectAt(pressPoint);
            if (pressObject != null) {
                // Create new Line and get the port direction / location
                line = newLine();
                pressPort = pressObject.getPortDirection(pressPoint);
                Point pressPortPoint = pressObject.getPortLocation(pressPort);

                // Add this line to canvas
                line.addToCanvas();
                line.updateSizeAndLocation(pressPortPoint, new Point(e.getX(), e.getY()));
            }
        } else {
            // Line exist -> update location
            Point point = new Point(e.getX(), e.getY());
            if (connectToPort) {
                // Get target object and set port location for connect
                Shape object = canvas.getBaseObjectAt(point);
                if (object != null && object != pressObject) {
                    int port = object.getPortDirection(point);
                    line.setHeadPoint(object.getPortLocation(port));
                } else {
                    line.setHeadPoint(point);
                }
            }else {
                line.setHeadPoint(point);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        boolean cancelLine = false;
        if (isDragged && line != null && pressObject != null) {
            Shape releaseObject = canvas.getBaseObjectAt(releasePoint);

            // Press and release at the base object but press object != release object
            // Connect these object by direction and port
            if (releaseObject != null && pressObject != releaseObject) {
                int releasePort = releaseObject.getPortDirection(releasePoint);
                Point releasePortPoint = releaseObject.getPortLocation(releasePort);

                line.connectLineToObject(pressObject, pressPort, Direction.TAIL);
                line.connectLineToObject(releaseObject, releasePort, Direction.HEAD);
                line.setHeadPoint(releasePortPoint);

            } else {
                cancelLine = true;
            }
        } else {
            cancelLine = true;
        }

        if (line != null && cancelLine) {
            line.removeFromCanvas();
        }
        cleanAttributes();
    }

    private void cleanAttributes() {
        isDragged = false;
        pressObject = null;
        line = null;
    }

}
