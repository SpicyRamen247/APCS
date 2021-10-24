/**
 * Joshua Gao APCS HW21 -- 2021-10-21 TASK: Implement each method without
 * typecasting. xtra: harmonic mean is the reciprocal of the arithmetic mean of
 * the reciprocals
 * DISCO
    * Math.pow and .sqrt and .cbrt and so on can only output doubles, since the range for ints is too constrained.
 * QCC
    * How do we return an integer root without typecasting?
    * Why does Java not have a normal built in power operator are they insane?
 **/

public class Stats {

    public static int mean(int a, int b) {
        return (a + b) / 2;
    }

    public static double mean(double a, double b) {
        return (double) (a + b) / 2;
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static double max(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int geoMean(int a, int b) {
        int product = a * b;
        return (int) Math.sqrt(product);
    }

    public static double geoMean(double a, double b) {
        return (double) Math.sqrt(a * b);
    }

    public static int max(int a, int b, int c) {
        if (a >= b && a >= c) {
            return (int) a;
        } else if (b >= a && b >= c) {
            return (int) b;
        } else if (c >= a && c >= b) {
            return (int) c;
        } else {
            return c;
        }
    }

    public static double max(double a, double b, double c) {
        if (a >= b && a >= c) {
            return (double) a;
        } else if (b >= a && b >= c) {
            return (double) b;
        } else if (c >= a && c >= b) {
            return (double) c;
        } else {
            return c;
        }
    }

    public static int geoMean(int a, int b, int c) {
        int product = a * b * c;
        return (int) Math.cbrt(product);
    }

    public static double geoMean(double a, double b, double c) {
        return (double) Math.cbrt(a * b * c);
    }

    // main method for testing functionality
    public static void main(String[] args) {

    }

}// end class