/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

/**
 *
 * @author s506571
 */
public class ZigZagEnemy extends SideToSideEnemy {
    protected int vely;
    public ZigZagEnemy(int velx, int direction, int vely) {
        super(velx, direction);
        this.vely = vely;
        health = 2;
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
