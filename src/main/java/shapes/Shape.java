package shapes;

import GUI.GLPoint;
import GUI.Paintable;

import java.awt.*;

public abstract class Shape implements Paintable {
    protected double width = 0;
    protected double height = 0;
    public double[] getColorArray(){
        return new double[]{color.getRed()/255.0, color.getGreen()/255.0, color.getBlue()/255.0};
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    protected Color color;
    protected GLPoint center;

    public GLPoint getCenter() {
        return center;
    }

    public void setCenter(GLPoint center) {
        this.center = center;
    }

    abstract public Shape clone();
    abstract public String getName();

    public void setColor(Color color) {
        this.color = color;
    }

}
