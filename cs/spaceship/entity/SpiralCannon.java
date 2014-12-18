/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

/**
 *
 * @author s506571
 */
public class SpiralCannon extends Cannon {
    protected double angle;
    protected int period;

    public SpiralCannon(Bullet base, int rate, double theta, int period) {
        super(base, rate);
        angle = theta;
        this.period = period;
    }

    @Override
    public void fire() {
        Bullet b = new Bullet(factory);
        b.posx += basePosition.x;
        b.posy += basePosition.y;
        b.velx =  Math.cos(angle) * factory.vely;
        b.vely = -Math.sin(angle) * factory.vely;
        b.fire();
        angle += (Math.PI * 2) / period;
    }
}
