/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

import cs.geom.Vector2D;

/**
 *
 * @author s506571
 */
public class Cannon {
    protected Bullet factory;
    protected int rate;
    protected int timer;

    protected Vector2D basePosition;

    public Cannon(Bullet base, int rate) {
        factory = base;
        this.rate = rate;
        basePosition = new Vector2D();
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Vector2D getBasePosition() {
        return basePosition;
    }

    public void setBasePosition(Vector2D basePosition) {
        this.basePosition = new Vector2D(basePosition);
    }

    // will fire if timer == 0
    public void fire() {
        if (timer == 0) {
            timer = rate;
            Bullet b = new Bullet(factory);
            b.posx += basePosition.x;
            b.posy += basePosition.y;
            b.fire();
        }
    }

    public void update() {
        if (timer > 0)
            timer--;
    }
}
