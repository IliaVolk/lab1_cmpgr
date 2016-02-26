package shapes;

import javax.media.opengl.GL2;

public class Pentagon extends Shape {
    @Override
    public Shape clone() {
        return new Pentagon();
    }

    @Override
    public String getName() {
        return "Pentagon";
    }

    @Override
    public void paint(GL2 gl) {
        gl.glColor3dv(getColorArray(), 0);
        gl.glBegin(GL2.GL_POLYGON);
        double r = width/2;
        double rver = height/2;
        //System.out.println("width = " + width + " height = " + height);
        for (int i = 1; i < 6; i++)
        {
            double angle = 2.0 * Math.PI * (float)i / (float)5 + Math.PI/2.0;
            double dx = r * Math.cos(angle);
            double dy = rver * Math.sin(angle);
            double x = center.getX() + dx;
            double y = center.getY() + dy;
            gl.glVertex2d(x, y);
            //glVertex2f(points[i].coordX, points[i].coordY);
        }
        gl.glEnd();
    }
}
