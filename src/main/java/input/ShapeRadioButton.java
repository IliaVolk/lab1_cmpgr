package input;

import shapes.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShapeRadioButton extends JRadioButton{
    private final FormHandler formHandler;
    private final Context context;
    private Shape shape;


    public ShapeRadioButton(Shape shape, FormHandler formHandler, Context context){
        this.shape = shape;
        this.formHandler = formHandler;
        this.context = context;
        setText(getShapeName());
        addActionListener(new ActionListenerImpl());
    }




    public Shape getShape() {
        return shape.clone();
    }

    public String getShapeName(){
        return shape.getName();
    }
    class ActionListenerImpl implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            for (ShapeRadioButton button : formHandler.getShapeButtons()){
                button.setSelected(false);
            }
            setSelected(true);
            context.setShape(getShape());
        }
    }

}

