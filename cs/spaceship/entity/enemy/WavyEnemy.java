/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

/**
 *
 * @author s506571
 */
public class WavyEnemy extends Enemy {
    protected int period; // in pixels
    protected int velocity;
    protected int amplitude;
    protected int x;
    @Override
    public void update() {
        position.y += velocity;
        position.x = (int)(x + Math.sin(position.y / period * Math.PI * 2) * amplitude);
        super.update();
    }

    public WavyEnemy(int period, int velocity, int amplitude, int x) {
        this.period = period;
        this.velocity = velocity;
        this.amplitude = amplitude;
        this.x = x;
    }
}
