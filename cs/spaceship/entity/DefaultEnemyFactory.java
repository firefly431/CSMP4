/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

import cs.geom.Vector2D;
import cs.spaceship.GameFrame;

/**
 *
 * @author s544545
 */
public class DefaultEnemyFactory implements EnemyFactory<Enemy> {
    @Override
    public Enemy build() {
        Enemy e = new Enemy();
        e.setPosition(new Vector2D((int)(GameFrame.WINDOW_WIDTH * Math.random()), 0));
        return e;
    }
}
