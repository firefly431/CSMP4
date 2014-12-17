/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

/**
 *
 * @author s506571
 */
public class DamageableEntity extends DeletableEntity {
    protected int health;
    public DamageableEntity() {
        health = 1;
    }
    @Override
    public void hitByBullet() {
        if (health == 1)
            super.hitByBullet();
        health--;
    }
}
