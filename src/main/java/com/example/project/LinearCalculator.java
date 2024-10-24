package com.example.project;

public class LinearCalculator {
    // INSTANCE VARIABLES 
    // 4 INTEGER variables (name them: x1,x2,y1,y2) 
    int x1;
    int x2;
    int y1;
    int y2;

    // CONSTRUCTOR
    public LinearCalculator(String cord1, String cord2) {
        cord1 = cord1.substring(1, cord1.length() - 1);
        cord2 = cord2.substring(1, cord2.length() - 1);
        int x = cord1.indexOf(",");
        int y = cord2.indexOf(",");
        x1 = Integer.parseInt(cord1.substring(0, x));
        y1 = Integer.parseInt(cord1.substring(x + 1));
        x2 = Integer.parseInt(cord2.substring(0, y));
        y2 = Integer.parseInt(cord2.substring(y + 1));
    }

    // METHODS
    // getters and setters for the 4 instance variables
    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public void setX1(int val) { x1 = val; }
    public void setY1(int val) { y1 = val; }
    public void setX2(int val) { x2 = val; }
    public void setY2(int val) { y2 = val; }

    // distance() -> returns a double. 
    public double distance() {
        double dis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return Math.round(dis * 100) / 100.0;
    }

    // yInt() -> returns a double.
    public double yInt() {
        if (x2 - x1 == 0) {
            return -999.99; // Undefined for vertical line
        }
        double yIntercept = y1 - (slope() * x1);
        return Math.round(yIntercept * 100) / 100.0;
    }

    // slope() -> returns a double. 
    public double slope() {
        if (x2 - x1 == 0) {
            return -999.99; // Vertical line
        }
        double slope = (double)(y2 - y1) / (x2 - x1);
        return Math.round(slope * 100) / 100.0;
    }

    // equations() -> returns a String.
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
            output += "+" + yInterceptValue; 
        } else if (yInterceptValue < 0) {
            output += yInterceptValue; 
        }
        return output; 
    } 

    // printInfo() -> returns a string of information
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


