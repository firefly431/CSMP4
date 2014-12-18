/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.GameFrame;
import cs.spaceship.entity.Cannon;
import cs.spaceship.entity.DamageableEntity;

/**
 *
 * @author s506571
 */
public class Enemy extends DamageableEntity {
    protected Cannon cannon;

    public int COLLISION_WIDTH() {
        return 40;
    }
    public int COLLISION_HEIGHT() {
        return 30;
    }

    @Override
    public void update() {
        if (cannon != null) {
            cannon.setBasePosition(position);
            cannon.fire();
            cannon.update();
        }
    }

    @Override
    public boolean shouldDelete() {
        return super.shouldDelete() ||
                (position.y > (COLLISION_HEIGHT() + GameFrame.WINDOW_HEIGHT));
    }

    public void equip(Cannon c) {
        cannon = c;
    }

    public void dequip() {
        cannon = null;
    }

    public Cannon getCannon() {
        return cannon;
    }
}
