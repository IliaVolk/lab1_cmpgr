package input;

import GUI.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.media.opengl.GLEventListener;

public class GlobalMouseListener implements MouseListener, MouseMotionListener {
    private Frame frame;
    private Context context;
    private GLEventListenerImpl glEventListener;
    private ShapeCreator shapeCreator = new ShapeCreator();

    public GlobalMouseListener(GLEventListenerImpl glEventListener,
                               Context context,
                               Frame frame) {
        this.context = context;
        this.frame = frame;
        this.glEventListener = glEventListener;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        shapeCreator.endCreation();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        shapeCreator.startCreation(e, context, glEventListener);
        frame.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shapeCreator.endCreation();
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        shapeCreator.continueCreation(e);
        frame.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
