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
    protected int count;
    protected EntityGroup<? super E> group;
    protected EnemyFactory<? super E> factory;

    public EnemyTimer(int rate, int count, EntityGroup<? super E> group, EnemyFactory<? super E> factory) {
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
                for (Object new_enemy : factory.buildArray()) {
                    if (group != null && new_enemy != null)
                        group.add((E)new_enemy);
                }
            }
        } else {
            timer--;
        }
    }
}
