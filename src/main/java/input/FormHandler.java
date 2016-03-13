package input;

import shapes.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FormHandler {
    private List<ShapeRadioButton> shapeButtons = new ArrayList<>();
    private Context context;
    private List<ColorMixRadioButton> colorMixButtons = new ArrayList<>();



    public FormHandler(Context context){
        this.context = context;
    }

    public List<ShapeRadioButton> getShapeButtons() {
        return shapeButtons;
    }

    public List<ColorMixRadioButton> getColorMixButtons() {
        return colorMixButtons;
    }

    public void createForms(){
        shapeButtons.add(new ShapeRadioButton(new Ellipse(), this, context));
        shapeButtons.add(new ShapeRadioButton(new Rectangle(), this, context));
        shapeButtons.add(new ShapeRadioButton(new Pentagon(), this, context));
        shapeButtons.add(new ShapeRadioButton(new Star(), this, context));
        shapeButtons.add(new ShapeRadioButton(new SandWatch(), this, context));
        ColorMixRadioButton and = new ColorMixRadioButton(Context.AND_COLOR_MIX_TYPE, this, context, "And");
        and.setSelected(true);
        colorMixButtons.add(and);
        //colorMixButtons.add(new ColorMixRadioButton(Context.NOT_COLOR_MIX_TYPE, this, context, "Not"));
        colorMixButtons.add(new ColorMixRadioButton(Context.OR_COLOR_MIX_TYPE, this, context, "Or"));
        colorMixButtons.add(new ColorMixRadioButton(Context.XOR_COLOR_MIX_TYPE, this, context, "Xor"));
        colorMixButtons.add(new ColorMixRadioButton(Context.NOT_AND_COLOR_MIX_TYPE, this, context, "Not and"));
        colorMixButtons.add(new ColorMixRadioButton(Context.NOT_OR_COLOR_MIX_TYPE, this, context, "Not or"));
        colorMixButtons.add(new ColorMixRadioButton(Context.NOT_XOR_COLOR_MIX_TYPE, this, context, "Not xor"));

    }
}






