package frc.robot.util;

import edu.wpi.first.math.MathUtil;

public class Color {

    public double r, g, b;

    public Color() {
        r = 0.0;
        g = 0.0;
        b = 0.0;
    }

    public Color(double c) {
        r = c;
        g = c;
        b = c;
    }

    public Color(double r_, double g_, double b_) {
        r = r_;
        g = g_;
        b = b_;
    }

    public Color mul(double c) {
        return new Color(r * c, g * c, b * c);
    }

    public void mulEq(double c) {
        r *= c;
        g *= c;
        b *= c;
    }

    public Color sub(Color c) {
        return new Color(r - c.r, g - c.g, b - c.b);
    }

    public Color add(Color c) {
        return new Color(r + c.r, g + c.g, b + c.b);
    }

    public int toInt() {
        int redval = (int) Math.round(255 * r);
        int greenval = (int) Math.round(255 * g);
        int blueval = (int) Math.round(255 * b);
        int alphaval = 255;
        return (alphaval << 24) | (redval << 16) | (greenval << 8) | blueval;
    }

    public void clamp() {
        r = MathUtil.clamp(r, 0.0, 1.0);
        g = MathUtil.clamp(g, 0.0, 1.0);
        b = MathUtil.clamp(b, 0.0, 1.0);
    }

    public static Color mix(Color a, Color b, double interp) {
        return a.mul(1.0 - interp).add(b.mul(interp));
    }

    public static double smoothstep(double edge0, double edge1, double x) {
        double t = MathUtil.clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);
        return t * t * (3.0 - 2.0 * t);
    }

}
