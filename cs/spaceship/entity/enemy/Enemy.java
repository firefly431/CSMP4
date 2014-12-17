/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.GameFrame;
import cs.spaceship.entity.DamageableEntity;

/**
 *
 * @author s506571
 */
public class Enemy extends DamageableEntity {
    public int COLLISION_WIDTH() {
        return 40;
    }
    public int COLLISION_HEIGHT() {
        return 30;
    }

    @Override
    public void update() {
        position.y++;
    }

    @Override
    public boolean shouldDelete() {
        return super.shouldDelete() ||
                (position.y > (COLLISION_HEIGHT() + GameFrame.WINDOW_HEIGHT));
    }
}
