package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Universe extends Entity {

    private int totalAmount;
    private List<Particle> data;
    private double range;

    public Universe(double _range, int _totalAmount) {
        super("the big universe");
        this.data = new ArrayList<>();
        this.range = _range;
        totalAmount = _totalAmount;
    }

    public void changeParticlesAmount(int delta) {
        totalAmount += delta;
    }

    private void fillParticleData(int amount, String name, double mass) {
        Random r = new Random();
        while (amount > 0) {
            double x = -range + 2 * range * r.nextDouble();
            double y = -range + 2 * range * r.nextDouble();
            double z = -range + 2 * range * r.nextDouble();

            data.add(new Particle(x, y, z, mass, name));

            amount--;
        }
    }

    public void initData() {
        int hydrogenAmount = (int)(0.75 * totalAmount);
        int heliumAmount = (int)(0.23 * totalAmount);
        int oxygenAmount = (int)(0.01 * totalAmount);
        int carbonAmount = (int)(0.005 * totalAmount);
        int otherAmount = totalAmount - hydrogenAmount - heliumAmount - oxygenAmount - carbonAmount;

        Hydrogen.changeParticlesAmount(hydrogenAmount);
        Helium.changeParticlesAmount(heliumAmount);
        Oxygen.changeParticlesAmount(oxygenAmount);
        Carbon.changeParticlesAmount(carbonAmount);

        Random r = new Random();

        fillParticleData(hydrogenAmount, "Hydrogen", 0.5);
        fillParticleData(heliumAmount, "Helium", 0.7);
        fillParticleData(oxygenAmount, "Oxygen", 0.2);
        fillParticleData(carbonAmount, "Carbon", 0.3);
        fillParticleData(otherAmount, "Other", 0.000000001);
    }

    public List<Particle> getData() {
        return this.data;
    }

    /*public double[] getMassCenter() { // r_mc = sum(m_i * r_i) / sum(m_i)
        double x_r = 0, y_r = 0, z_r = 0;
        double m_summary = 0;
        for (Particle p : this.data) {
            x_r += p.getMass() * p.x;
            y_r += p.getMass() * p.y;
            z_r += p.getMass() * p.z;
            m_summary += p.getMass();
        }
        x_r /= m_summary;
        y_r /= m_summary;
        z_r /= m_summary;
        return new double[] {x_r, y_r, z_r};
    }*/

    public Vector3d getVector3dMassCenter() {
        Vector3d result = new Vector3d(0, 0, 0);
        double m_summary = 0;
        for (Particle p : this.data) {
            p.r.multiply(p.getMass());
            result.addVector3d(p.r);
            m_summary += p.getMass();
        }
        result.multiply(1 / m_summary);
        return result;
    }
}
