/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

/**
 *
 * @author s544545
 */
public interface EnemyFactory<E extends Enemy> {
    public E build();
}
