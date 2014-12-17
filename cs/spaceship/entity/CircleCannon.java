/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

/**
 *
 * @author s506571
 */
public class CircleCannon extends Cannon {
    protected int num;
    // factory's y velocity is speed
    public CircleCannon(Bullet base, int rate, int num) {
        super(base, rate);
        this.num = num;
    }

    @Override
    public void fire() {
        if (timer == 0) {
            timer = rate;
            for (int i = 0; i < num; i++) {
                Bullet b = new Bullet(factory);
                b.posx += basePosition.x;
                b.posy += basePosition.y;
                b.velx =  Math.cos(i * Math.PI / num * 2) * b.vely;
                b.vely = -Math.sin(i * Math.PI / num * 2) * b.vely;
                b.fire();
            }
        }
    }
}
