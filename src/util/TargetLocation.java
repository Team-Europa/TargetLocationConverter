package util;

public class TargetLocation {
    public static double[][] quaternionToRotationMatrix(Quaternion quaternion) {
        double w = quaternion.getW(), x = quaternion.getX(), y = quaternion.getY(), z = quaternion.getZ();
        return new double[][] {
                {1 - 2*y*y - 2*z*z, 2*x*y - 2*w*z,      2*x*z + 2*w*y       },
                {2*x*y + 2*w*z,     1 - 2*x*x - 2*z*z,  2*y*z - 2*w*x       },
                {2*x*z - 2*w*y,     2*y*z + 2*w*x,      1 - 2*x*x - 2*y*y   }
        };
    }
}
