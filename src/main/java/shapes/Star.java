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
        double bigConstWidth = width/2;
        double bigConstHeight = height/2;
        double smallConstWidth = width/6;
        double smallConstHeight = height/6;
        {
            gl.glVertex2d(center.getX(), center.getY());
            for(int i = 1; i<=11; i++)
                if(i%2==0)
                {
                    gl.glVertex2d((center.getX() + bigConstWidth * Math.sin(2 * Math.PI * ((double) i) / 10.0)),
                            (center.getY() + bigConstHeight * Math.cos(2 * Math.PI * ((double) i) / 10.0)));
                }
                else
                {
                    gl.glVertex2d((center.getX() + smallConstWidth * Math.sin(2 * Math.PI * ((double) i) / 10.0)),
                            (center.getY() + smallConstHeight * Math.cos(2 * Math.PI * ((double) i) / 10.0)));
                }

        }
        gl.glEnd();
    }
}
