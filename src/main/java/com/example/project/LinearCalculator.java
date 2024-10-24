package com.example.project;

public class LinearCalculator {
    // INSTANCE VARIABLES 
    // 4 INTEGER variables (name them: x1,x2,y1,y2) 
    int x1;
    int x2;
    int y1;
    int y2;

    // CONSTRUCTOR
    // 1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    // For example, "(1,2)" and "(3,4)" would be two parameter values 
    // You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String cord1, String cord2) {
        cord1 = cord1.substring(1, cord1.length() - 1); // OK so it gets rid of the parathesis and than founds the location of the x and y values in their String and than sets those values to x1 x2 y 1 and y2.
        cord2 = cord2.substring(1, cord2.length() - 1);
        int x = cord1.indexOf(",");
        int y = cord2.indexOf(",");
        x1 = Integer.parseInt(cord1.substring(0, x));
        y1 = Integer.parseInt(cord1.substring(x + 1));
        x2 = Integer.parseInt(cord2.substring(0, y));
        y2 = Integer.parseInt(cord2.substring(y + 1));
    }

    // METHODS
    // getters and setters for the 4 instance variables (8 methods total)
    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public void setX1(int val) { x1 = val; }
    public void setY1(int val) { y1 = val; }
    public void setX2(int val) { x2 = val; }
    public void setY2(int val) { y2 = val; }

    // distance() -> returns a double. 
    // calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance() {
        double dis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // This is based on the distance formula learned in Algebra.
        return Math.round(dis * 100) / 100.0;
    }

    // yInt() -> returns a double.
    // calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    // if y-int is undefined, should return -999.99
    public double yInt() {
        if (x2 - x1 == 0) {
            return -999.99; // Undefined for vertical line
        }
        double yIntercept = y1 - (slope() * x1); // y =mx + b so y - mx = b
        return Math.round(yIntercept * 100) / 100.0;
    }

    // slope() -> returns a double. 
    // calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    // if slope is undefined, should return -999.99
    public double slope() {
        if (x2 - x1 == 0) {
            return -999.99; // Vertical line
        }
        double slope = (double)(y2 - y1) / (x2 - x1); // ok so for this y2-y1/x2-x1 is the equation for slope and since we have these values set as int we must cast it as a double 
        return Math.round(slope * 100) / 100.0;
    }

    // equations() -> returns a String.
    // calculates the final equation in y=mx+b form and returns the string
    // if the equation has no slope, the equation should return -> "undefined"
    // HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation() {
        double slopeValue = slope();
        double yInterceptValue = yInt();

        if (slopeValue == -999.99) {
            return "undefined";
        }
        if (slopeValue == 0.0) {
            return "y=" + yInterceptValue;
        }
        String output = "y=" + slopeValue + "x";
        if (yInterceptValue > 0) {
            output += "+" + yInterceptValue; // checks positive and negative value 
        } else if (yInterceptValue < 0) {
            output += yInterceptValue;
        }
        return output;
    }

    // printInfo() -> returns a string of information
    // this method is tested but you can also call it in your main method if gradle tests are 
    // not working.
    public String printInfo() {
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        return str;
    }
}

