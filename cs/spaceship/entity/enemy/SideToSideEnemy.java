/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.GameFrame;
import cs.spaceship.GamePanel;
import cs.spaceship.entity.Bullet;
import cs.spaceship.entity.Cannon;
import java.awt.Color;

/**
 *
 * @author s506571
 */
public class SideToSideEnemy extends Enemy {
    public int direction = 12;
    Cannon cannon = new Cannon(new Bullet(0, 0,
            8, 0, 6,
            Color.BLUE,
            ((GamePanel)GameFrame.get().getCurrentPanel()).playerG), 40);
    public SideToSideEnemy() {
        health = 5;
    }
    @Override
    public void update() {
        cannon.setBasePosition(position);
        position.x += direction;
        int left = getAABB().getTopLeft().x;
        int right = getAABB().getBottomRight().x;
        if (left < 0 || right >= GameFrame.WINDOW_WIDTH) {
            direction *= -1;
        }
        cannon.fire();
        cannon.update();
    }
}
