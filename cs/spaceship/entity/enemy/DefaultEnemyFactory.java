/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.geom.Vector2D;
import cs.spaceship.GameFrame;

/**
 *
 * @author s544545
 */
public class DefaultEnemyFactory extends EnemyFactory {
    @Override
    public Enemy build() {
        Enemy e = new LineEnemy(1);
        e.setPosition(new Vector2D((int)(GameFrame.WINDOW_WIDTH * Math.random()), 0));
        return e;
    }
}
