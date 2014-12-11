/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

/**
 *
 * @author s544545
 */
public class EnemyTimer<E extends Enemy> {
    protected int rate;
    protected int timer;
    protected EntityGroup<? super E> group;
    protected EnemyFactory<? super E> factory;

    public EnemyTimer(int rate, EntityGroup<? super E> group, EnemyFactory<? super E> factory) {
        this.rate = rate;
        this.timer = 0;
        this.group = group;
        this.factory = factory;
    }

    public void update() {
        if (timer == 0) {
            timer = rate;
            //make new enemy
            E new_enemy = (E)factory.build();
            if (group != null && new_enemy != null)
                group.add(new_enemy);
        } else {
            timer--;
        }
    }
}
