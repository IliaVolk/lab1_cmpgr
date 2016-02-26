package input;

import GUI.GLPoint;
import GUI.Paintable;
import GUI.Util;
import shapes.Shape;

import java.awt.event.MouseEvent;
import java.util.List;

public class ShapeCreator {
    volatile private Shape shape;
    volatile private GLPoint startOfCreationPoint;
    public void startCreation(MouseEvent e, Context context, GLEventListenerImpl dest){
        this.shape = context.getShape().clone();
        GLPoint point = Util.screenToGL(e.getX(), e.getY());
        startOfCreationPoint  = new GLPoint(point.getX(), point.getY());
        shape.setCenter(point);
        shape.setWidth(0.001);
        shape.setHeight(0.001);
        shape.setColor(context.getColor());
        dest.addPaintable(shape);
        System.out.println("Shape added " + shape);
        System.out.println("Point " + startOfCreationPoint);
    }

    public void continueCreation(MouseEvent e){
        //System.out.println("Drugging Shape " + shape);
        //System.out.println("Drugging Point " + startOfCreationPoint);
        if (shape != null && startOfCreationPoint != null){
                GLPoint point = Util.screenToGL(e.getX(), e.getY());

                shape.getCenter().setX(
                        (startOfCreationPoint.getX()+point.getX())/2
                );

                shape.getCenter().setY(
                        (startOfCreationPoint.getY()+point.getY())/2
                );
            shape.setWidth(Math.abs(point.getX() - startOfCreationPoint.getX()));
            shape.setHeight(Math.abs(point.getY() - startOfCreationPoint.getY()));
                System.out.println(""+
                        //"Shape width = " + shape.getWidth()+
                //" height = " + shape.getHeight() +
                " center.x = "  + shape.getCenter().getX() +
                " center.y = " + shape.getCenter().getY() +
                "\n startpoint.x = " + startOfCreationPoint.getX() +
                " startpoint.y = " + startOfCreationPoint.getY()+
                " point.x = " + point.getX() +
                " point.y = " + point.getY());
        }
    }
    public void endCreation(){
        shape = null;
    }
}
