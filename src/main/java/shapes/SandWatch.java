package shapes;

import javax.media.opengl.GL2;

public class SandWatch extends Shape {
    @Override
    public Shape clone() {
        return new SandWatch();
    }

    @Override
    public String getName() {
        return "Sand Watch";
    }

    @Override
    public void paint(GL2 gl) {
        gl.glColor3dv(getColorArray(),0);
        gl.glBegin(GL2.GL_POLYGON);
        double x = center.getX();
        double y = center.getY();
        {
            gl.glVertex2d((x-width/3.0), (y-height/2.0));
            gl.glVertex2d((x+width/3.0), (y-height/2.0));
            gl.glVertex2d((x), (y+height/15.0));
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        {
            gl.glVertex2d((x-width/3), (y+height/2));
            gl.glVertex2d((x+width/3), (y+height/2));
            gl.glVertex2d((x), (y-height/15));
        }
        gl.glEnd();
    }
}
