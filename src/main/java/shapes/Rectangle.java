package shapes;

import javax.media.opengl.GL2;
import java.awt.*;

public class Rectangle extends Shape {


    @Override
    public Shape clone() {
        return new Rectangle();
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void paint(GL2 gl) {
        gl.glColor3dv(getColorArray(),0);
        gl.glBegin(GL2.GL_QUADS);
        double x = center.getX() - width / 2;
        double y = center.getY() + height / 2;
        gl.glVertex2d(x, y);
        gl.glVertex2d(x + width, y);
        gl.glVertex2d(x + width, y - height);
        gl.glVertex2d(x, y - height);
        gl.glEnd();
    }
}
