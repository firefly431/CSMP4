/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.entity.EntityGroup;

/**
 *
 * @author s544545
 */
public class EnemyTimer {
    protected int rate;
    protected int timer;
    protected int count;
    protected EntityGroup<? super Enemy> group;
    protected EnemyFactory factory;

    public EnemyTimer(int rate, int count, EntityGroup<? super Enemy> group, EnemyFactory factory) {
        this.rate = rate;
        this.count = count;
        this.timer = 0;
        this.group = group;
        this.factory = factory;
    }

    public void update() {
        if (timer == 0) {
            timer = rate;
            for (int i = 0; i < count; i++) {
                //make new enemy
                for (Enemy new_enemy : factory.buildArray()) {
                    if (group != null && new_enemy != null)
                        group.add(new_enemy);
                }
            }
        } else {
            timer--;
        }
    }
}
