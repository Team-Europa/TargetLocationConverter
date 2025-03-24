package util;

public class Quaternion {
    private final double w, x, y, z;

    public Quaternion(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getW() {
        return w;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String toString() {
        return w + " + " + x + "i + " + y + "j + " + z + "k";
    }

    public double norm() {
        return Math.sqrt(w * w + x * x + y * y + z * z);
    }

    public Quaternion conjugate() {
        return new Quaternion(w, -x, -y, -z);
    }

    public Quaternion plus(Quaternion b) {
        return new Quaternion(w + b.w, x + b.x, y + b.y, z + b.z);
    }

    public Quaternion times(Quaternion b) {
        double y0 = w * b.w - x * b.x - y * b.y - z * b.z;
        double y1 = w * b.x + x * b.w + y * b.z - z * b.y;
        double y2 = w * b.y - x * b.z + y * b.w + z * b.x;
        double y3 = w * b.z + x * b.y - y * b.x + z * b.w;
        return new Quaternion(y0, y1, y2, y3);
    }
}
