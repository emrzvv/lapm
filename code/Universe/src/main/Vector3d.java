package main;

public class Vector3d {
    private double x, y, z;

    public Vector3d(double _x, double _y, double _z) {
        this.x = _x;
        this.y = _y;
        this.z = _z;
    }

    public void addVector3d(Vector3d v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }

    public void multiply(double lambda) {
        this.x *= lambda;
        this.y *= lambda;
        this.z *= lambda;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }
}
