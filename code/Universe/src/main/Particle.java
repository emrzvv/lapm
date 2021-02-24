package main;

public class Particle extends Entity {
    public Vector3d r; // то же самое, что радиус-вектор
    private double mass; // масса
    public static int amount; // количество частиц одного типа

    public Particle(double _x, double _y, double _z, double _m, String _name) {
        super(_name);
        r = new Vector3d(_x, _y, _z);
        this.mass = _m;
    }

    public double getMass() {
        return this.mass;
    }

    public static void changeParticlesAmount(int delta) {
        amount += delta;
    }

    public void displayParticle() {
        System.out.println(name + ": [r: " + r.getX() + " " + r.getY() + " " + r.getZ() + "\nmass: " + mass + "]");
    }
}