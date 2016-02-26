package GUI;

import javax.media.opengl.GL2;
import java.util.ArrayList;
import java.util.List;

public class PointHandler implements Paintable{
    private List<GLPoint> points = new ArrayList<>();
    public void addPoint(GLPoint p){
        points.add(p);
    }

    @Override
    public void paint(GL2 gl){
        //System.out.println("Paint points");
        gl.glColor3d(0,0,1);
        gl.glPointSize(10);
        gl.glBegin(GL2.GL_POINTS);
        for (GLPoint p : points){
            gl.glVertex2dv(p.getArr(),0);
        }
        gl.glEnd();
    }
}
