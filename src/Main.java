import util.Position;
import util.Quaternion;
import util.TargetLocation;

import java.util.Scanner;

public class Main {
    /*
     * This is a test environment for the TargetLocation.
     * In this test, the expected output would be: "Global Position: (4, 2, 5)"
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test data inputting
        scanner.useDelimiter(",");
        System.out.println("Enter the local position of the target (x, y, z): ");
        String inputLine = scanner.nextLine();
        String[] inputLn = inputLine.trim().split(",");
        double localX = Double.parseDouble(inputLn[0]);
        double localY = Double.parseDouble(inputLn[1]);
        double localZ = Double.parseDouble(inputLn[2]);
        Position localPosition = new Position(localX, localY, localZ);

        System.out.println("Enter the robot global position (x, y, z): ");
        String inputLine2 = scanner.nextLine();
        String[] inputLn2 = inputLine2.trim().split(",");
        double robotX = Double.parseDouble(inputLn2[0]);
        double robotY = Double.parseDouble(inputLn2[1]);
        double robotZ = Double.parseDouble(inputLn2[2]);
        Position localOrigin = new Position(robotX, robotY, robotZ);

        System.out.println("%nEnter the robot orientation (w, x, y, z): ");
        String inputLine3 = scanner.nextLine();
        String[] inputLn3 = inputLine3.trim().split(",");
        double orientationW = Double.parseDouble(inputLn3[0]);
        double orientationX = Double.parseDouble(inputLn3[1]);
        double orientationY = Double.parseDouble(inputLn3[2]);
        double orientationZ = Double.parseDouble(inputLn3[3]);
        Quaternion orientation = new Quaternion(orientationW, orientationX, orientationY, orientationZ);

        Position globalPoint = TargetLocation.transformPosition(localPosition, localOrigin, orientation);

        System.out.printf("Global Position: (%.5f, %.5f, %.5f)%n",
                globalPoint.getX(), globalPoint.getY(), globalPoint.getZ());
    }
}