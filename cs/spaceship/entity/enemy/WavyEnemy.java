/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.GameFrame;

/**
 *
 * @author s506571
 */
public class WavyEnemy extends Enemy {
    @Override
    public void update() {
        position.y += 5;
        position.x = (int)(GameFrame.WINDOW_WIDTH / 2 + Math.sin(position.y / 100.0) * GameFrame.WINDOW_WIDTH / 3);
    }
}
