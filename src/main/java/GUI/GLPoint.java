package GUI;

public class GLPoint {
    public GLPoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    private double x;
    private double y;

    public double[] getArr(){
        return new double [] {x,y};
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
