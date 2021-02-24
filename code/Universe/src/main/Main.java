package main;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Universe universe = new Universe(100, 100000);
        universe.initData();
        List<Particle> d = universe.getData();
        for (Particle p : d) {
            p.displayParticle();
        }
        Vector3d res = universe.getVector3dMassCenter();
        System.out.println(res.getX() + " " + res.getY() + " " + res.getZ());
    }
}
