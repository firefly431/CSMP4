/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.Animation;

/**
 * @author s506571
 */
public class ZigZagEnemy extends SideToSideEnemy {
    public static final Animation ANIM = new Animation("zigzag%d.png", 1, 0);
    protected int vely;
    public int COLLISION_WIDTH() {
        return 20;
    }
    public int COLLISION_HEIGHT() {
        return 40;
    }
    public ZigZagEnemy(int velx, int direction, int vely) {
        super(velx, direction);
        this.vely = vely;
        health = 2;
        animator = ANIM.new Animator();
    }
    public ZigZagEnemy(int velx, int vely) {
        this(velx, 1, vely);
    }
    @Override
    public void update() {
        position.y += vely;
        super.update();
    }
}
