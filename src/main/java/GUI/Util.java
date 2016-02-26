package GUI;

import java.awt.*;

public class Util {

    private static Frame frame;
    public static GLPoint screenToGL(double x, double y){
        Dimension dimension = frame.getSize();
        return new GLPoint(
                2 * (x-8) / (dimension.width-16 ) - 1,
                2 * (dimension.height-38 - y+30) / (dimension.height-38) - 1
        );
    }
    static void setFrame(Frame f){
        frame = f;
    }
}
