package input;

import shapes.Ellipse;
import shapes.Shape;

import javax.media.opengl.GL;
import java.awt.*;

public class Context {
    public static final int AND_COLOR_MIX_TYPE = GL.GL_AND;
    public static final int OR_COLOR_MIX_TYPE = GL.GL_OR;
    public static final int XOR_COLOR_MIX_TYPE = GL.GL_XOR;
    //public static final int NOT_COLOR_MIX_TYPE = GL.GL_INVERT;
    public static final int NOT_AND_COLOR_MIX_TYPE = GL.GL_NAND;
    public static final int NOT_OR_COLOR_MIX_TYPE = GL.GL_NOR;
    public static final int NOT_XOR_COLOR_MIX_TYPE = GL.GL_EQUIV;
    //public static final int NOT_COLOR_MIX_TYPE = GL.GL_INVERT;



    private Shape shape = new Ellipse();
    private boolean colorMixTypeChanged = true;
    private boolean colorMixDisabled = true;
    private int colorMixType = AND_COLOR_MIX_TYPE;
    private Color color = Color.BLACK;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setColorMixDisabled(boolean colorMixDisabled) {
        this.colorMixDisabled = colorMixDisabled;
    }

    public boolean isColorMixTypeChanged() {
        return colorMixTypeChanged;
    }

    public boolean isColorMixDisabled() {
        return colorMixDisabled;
    }



    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
        shape.setColor(color);
    }

    public int getColorMixType() {
        colorMixTypeChanged = false;
        return colorMixType;
    }

    public void setColorMixType(int colorMixType) {
        this.colorMixType = colorMixType;
        colorMixTypeChanged = true;
    }
}
