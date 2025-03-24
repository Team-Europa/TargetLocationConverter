package util;

public class Quaternion {
    private final double x0, x1, x2, x3;

    public Quaternion(double x0, double x1, double x2, double x3) {
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    public String toString() {
        return x0 + " + " + x1 + "i + " + x2 + "j + " + x3 + "k";
    }

    public double norm() {
        return Math.sqrt(x0 * x0 + x1 * x1 + x2 * x2 + x3 * x3);
    }

    public Quaternion conjugate() {
        return new Quaternion(x0, -x1, -x2, -x3);
    }

    public Quaternion plus(Quaternion b) {
        return new Quaternion(x0 + b.x0, x1 + b.x1, x2 + b.x2, x3 + b.x3);
    }

    public Quaternion times(Quaternion b) {
        double y0 = x0 * b.x0 - x1 * b.x1 - x2 * b.x2 - x3 * b.x3;
        double y1 = x0 * b.x1 + x1 * b.x0 + x2 * b.x3 - x3 * b.x2;
        double y2 = x0 * b.x2 - x1 * b.x3 + x2 * b.x0 + x3 * b.x1;
        double y3 = x0 * b.x3 + x1 * b.x2 - x2 * b.x1 + x3 * b.x0;
        return new Quaternion(y0, y1, y2, y3);
    }
}
