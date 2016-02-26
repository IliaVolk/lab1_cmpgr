package input;

import GUI.Frame;
import shapes.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorMixRadioButton extends JRadioButton{
    private final FormHandler formHandler;
    private final Context context;
    private int colorMixType;


    public ColorMixRadioButton(int mixType, FormHandler formHandler, Context context, String text){
        this.colorMixType = mixType;
        this.formHandler = formHandler;
        this.context = context;
        setText(text);
        //addMouseListener(new ClickMouseListener());
        addActionListener(new ActionListenerImpl());
    }




    public int getColorMixType() {
        return colorMixType;
    }

    public String getColorMixTypeName(){
        return "";
    }
    class ActionListenerImpl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (ColorMixRadioButton button : formHandler.getColorMixButtons()){
                button.setSelected(false);
            }
            setSelected(true);
            context.setColorMixType(colorMixType);
        }
    }


}
