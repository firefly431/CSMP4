/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

/**
 *
 * @author s506571
 */
public class Enemy extends DeletableEntity {
    public int COLLISION_WIDTH() {
        return 40;
    }
    public int COLLISION_HEIGHT() {
        return 30;
    }
}
