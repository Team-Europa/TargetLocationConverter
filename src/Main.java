import util.Position;
import util.Quaternion;
import util.TargetLocation;

public class Main {
    /*
     * This is a test environment for the TargetLocation.
     * In this test, the expected output would be: "Global Position: (4, 2, 5)"
     */
    public static void main(String[] args) {
        Position localOrigin = new Position(3,2,5);
        double angle = Math.toRadians(0);
        Quaternion orientation = new Quaternion(
                Math.cos(angle/2),
                0,
                Math.sin(angle/2),
                0
        );
        Position localPosition = new Position(1,0,0);

        Position globalPoint = TargetLocation.transformPosition(localPosition, localOrigin, orientation);

        System.out.printf("Global Position: (%.5f, %.5f, %.5f)%n",
                globalPoint.getX(), globalPoint.getY(), globalPoint.getZ());
    }
}