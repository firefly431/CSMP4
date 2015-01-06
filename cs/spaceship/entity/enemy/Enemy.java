/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.Animation;
import cs.spaceship.GameFrame;
import cs.spaceship.entity.Cannon;
import cs.spaceship.entity.DamageableEntity;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author s506571
 */
public class Enemy extends DamageableEntity {
    protected Cannon cannon;
    protected Animation.Animator animator;

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
        if (animator != null)
            animator.animate();
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

    @Override public void draw(Graphics g) {
        if (animator != null) {
            Image img = animator.get();
            g.drawImage(img, position.x - img.getWidth(null) / 2, position.y - img.getHeight(null) / 2, null);
        } else super.draw(g);
    }
}
