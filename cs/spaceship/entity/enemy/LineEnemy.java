/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.Animation;

/**
 *
 * @author s506571
 */
public class LineEnemy extends Enemy {
    public static final Animation ANIM = new Animation("stapler%d.png", 2, Animation.fromFPS(10));
    protected int velocity = 1;

    public LineEnemy(int velocity) {
        setVelocity(velocity);
        animator = ANIM.new Animator();
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public void update() {
        position.y += velocity;
        super.update();
    }
}
