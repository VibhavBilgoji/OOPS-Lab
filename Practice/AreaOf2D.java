public class AreaOf2D {

    public static void main(String[] args) {
        int radius = 10;
        double circleArea = Math.PI * radius * radius;
        System.out.println(
            "Area of the circle with radius " + radius + " is: " + circleArea
        );

        int squareSide = 4;
        double squareArea = Math.pow(squareSide, 2);
        System.out.println(
            "Area of the square with side " + squareSide + " is: " + squareArea
        );

        double triBase = 10.0;
        double triHeight = 5.0;
        double triArea = 0.5 * triBase * triHeight;
        System.out.println(
            "Area of the triangle with base " +
                triBase +
                " and height " +
                triHeight +
                " is: " +
                triArea
        );

        double trapBase1 = 8.0;
        double trapBase2 = 5.0;
        double trapHeight = 10;
        double trapArea = 0.5 * (trapBase1 + trapBase2) * trapHeight;
        System.out.println(
            "Area of the trapezoid with bases " +
                trapBase1 +
                " and " +
                trapBase2 +
                " and height " +
                trapHeight +
                " is: " +
                trapArea
        );

        double pentaPeri = 20.0;
        double apothem = 5.0;
        double pentaArea = 0.5 * pentaPeri * apothem;
        System.out.println(
            "Area of the regular pentagon with perimeter " +
                pentaPeri +
                " and apothem " +
                apothem +
                " is: " +
                pentaArea
        );

        double rhombusDiag1 = 12.0;
        double rhombusDiag2 = 8.0;
        double rhombusArea = 0.5 * rhombusDiag1 * rhombusDiag2;
        System.out.println(
            "Area of the rhombus with diagonals " +
                rhombusDiag1 +
                " and " +
                rhombusDiag2 +
                " is: " +
                rhombusArea
        );

        double rectSide1 = 6.0;
        double rectSide2 = 9.0;
        double rectArea = rectSide1 * rectSide2;
        System.out.println(
            "Area of the rectangle with sides " +
                rectSide1 +
                " and " +
                rectSide2 +
                " is: " +
                rectArea
        );

        double paraBase = 10.0;
        double paraHeight = 6.0;
        double paraArea = paraBase * paraHeight;
        System.out.println(
            "Area of the parallelogram with base " +
                paraBase +
                " and height " +
                paraHeight +
                " is: " +
                paraArea
        );

        double ovalMajorAxis = 11.0;
        double ovalMinorAxis = 7.0;
        double ovalArea = ovalMajorAxis * ovalMinorAxis * Math.PI;
        System.out.println(
            "Area of the oval with major axis " +
                ovalMajorAxis +
                " and minor axis " +
                ovalMinorAxis +
                " is: " +
                ovalArea
        );
    }
}
