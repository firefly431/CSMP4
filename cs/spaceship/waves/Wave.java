/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.waves;

import cs.spaceship.entity.EntityGroup;
import cs.spaceship.entity.Targetable;
import cs.spaceship.entity.enemy.Enemy;

/**
 *
 * @author s506571
 */
public interface Wave {
    public void generateEnemies(final EntityGroup<Enemy> target, final EntityGroup<? extends Targetable> playerG);
}