/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.geom.Vector2D;
import cs.spaceship.GameFrame;

/**
 *
 * @author s506571
 */
public class FactoryMultiplier extends EnemyFactory {
    protected EnemyFactory factory;
    protected int num;

    public FactoryMultiplier(EnemyFactory f, int n) {
        factory = f;
        num = n;
    }

    @Override
    public Enemy build() {
        return factory.build();
    }

    @Override
    public Enemy[] buildArray() {
        Enemy[] ret = new Enemy[num];
        for (int i = 0; i < num; i++) {
            ret[i] = factory.build(i, num);
            ret[i].setPosition(new Vector2D(
                    GameFrame.WINDOW_WIDTH / num / 2
                    + i * GameFrame.WINDOW_WIDTH / num,
                    ret[i].getPosition().y));
        }
        return ret;
    }
}
