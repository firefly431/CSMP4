/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.GameFrame;

/**
 * @author s506571
 */
public class SideToSideEnemy extends Enemy {
    protected int direction;
    protected int velx;
    public SideToSideEnemy(int velx, int direction) {
        health = 5; // default
        this.velx = velx;
        this.direction = direction;
    }
    public SideToSideEnemy(int velx) {
        this(velx, 1);
    }
    @Override
    public void update() {
        position.x += direction * velx;
        int left = getAABB().getTopLeft().x;
        int right = getAABB().getBottomRight().x;
        if (left < 0 || right >= GameFrame.WINDOW_WIDTH) {
            direction *= -1;
            if (left < 0)
                position.x -= left * 2;
            else
                position.x -= (right - GameFrame.WINDOW_WIDTH) * 2;
        }
        super.update();
    }
}
