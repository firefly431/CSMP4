/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

/**
 *
 * @author s506571
 */
public class DeletableEntity extends Entity implements Targetable {
    protected boolean delete;

    public void markForDeletion() {
        delete = true;
    }

    @Override
    public boolean shouldDelete() {
        return delete;
    }

    // avoid if possible, will do nothing if already deleted
    public void unmarkForDeletion() {
        delete = false;
    }

    @Override
    public void hitByBullet() {
        markForDeletion();
    }
}
