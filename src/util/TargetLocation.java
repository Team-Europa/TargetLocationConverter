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

    public static Position transformPosition(Position localTarget, Position localOrigin, Quaternion orientation) {
        double[][] R = quaternionToRotationMatrix(orientation);
        double[] localPositionMatrix = {localTarget.getX(), localTarget.getY(), localTarget.getZ()};
        double[] globalPosition = new double[3];
        for (int i = 0; i < 3; i++) {
            globalPosition[i] = localOrigin.getX();
            for (int j = 0; j < 3; j++) {
                globalPosition[i] += R[i][j] * localPositionMatrix[j];
            }
        }
        return new Position(globalPosition[0], globalPosition[1], globalPosition[2]);
    }
}
