package shapes;

import javax.media.opengl.GL2;

public class Star extends Shape {
    @Override
    public Shape clone() {
        return new Star();
    }

    @Override
    public String getName() {
        return "Star";
    }

    @Override
    public void paint(GL2 gl) {
        gl.glColor3dv(getColorArray(), 0);
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        {

        }
        gl.glEnd();

    }
}
