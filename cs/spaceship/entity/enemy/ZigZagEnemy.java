/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.GameFrame;
import cs.spaceship.GamePanel;
import cs.spaceship.entity.Bullet;
import cs.spaceship.entity.CircleCannon;
import java.awt.Color;

/**
 *
 * @author s506571
 */
public class ZigZagEnemy extends SideToSideEnemy {
    public ZigZagEnemy() {
        super();
        direction = 20;
        cannon = new CircleCannon(new Bullet(
            0, 0, 12, 0, 4, Color.yellow, ((GamePanel)GameFrame.get().getCurrentPanel()).playerG), 90, 12);
        health = 2;
    }
    @Override
    public void update() {
        super.update();
        position.y += 1;
    }
}
