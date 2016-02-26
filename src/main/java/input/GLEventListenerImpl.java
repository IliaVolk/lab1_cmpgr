package input;



import GUI.Paintable;
import shapes.Shape;

import javax.swing.JFrame;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLJPanel;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GLEventListenerImpl implements GLEventListener {
    public GLEventListenerImpl(Context context){
        this.context = context;
    }
    private Context context;
    private Color bkColor;
    private List<Paintable> paintables = new LinkedList<>();
    public void addPaintable(Paintable p){
        paintables.add(p);
    }
    public void clearPaintable(){
        paintables.clear();
    }

    public void setBkColor(Color color) {
        this.bkColor = color;
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        glAutoDrawable.getContext().setSwapInterval(100);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        if (context.isColorMixDisabled()){
            gl.glDisable(GL.GL_COLOR_LOGIC_OP);
        }else {
            gl.glEnable(GL.GL_COLOR_LOGIC_OP);
            gl.glLogicOp(context.getColorMixType());
        }
        if (context.isColorMixTypeChanged()){
            gl.glLogicOp(context.getColorMixType());
        }
        if (bkColor != null)
            gl.glClearColor((float)(bkColor.getRed()/255.0),(float)(bkColor.getGreen()/255.0),(float)(bkColor.getBlue()/255.0),0);
        else
            gl.glClearColor(1, 1, 1, 0);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        for (Paintable p : paintables){
            p.paint(gl);
        }

        /*gl.glBegin(GL2.GL_QUADS);
        {
            gl.glColor3d(0,1,0);
            gl.glVertex2d(-0.5, 0.5);
            gl.glVertex2d(0.5, 0.5);
            gl.glVertex2d(0.5, -0.5);
            gl.glVertex2d(-0.5, -0.5);
        }
        gl.glEnd();*/

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
