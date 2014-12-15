/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

/**
 *
 * @author s544545
 */
public abstract class EnemyFactory<E extends Enemy> {
    public abstract E build();
    public E[] buildArray() {
        return (E[])new Object[] {build()};
    }
}
