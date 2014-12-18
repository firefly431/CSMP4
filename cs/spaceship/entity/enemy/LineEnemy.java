/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

/**
 *
 * @author s506571
 */
public class LineEnemy extends Enemy {
    protected int velocity = 1;

    public LineEnemy(int velocity) {
        setVelocity(velocity);
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public void update() {
        position.y += velocity;
        super.update();
    }
}
