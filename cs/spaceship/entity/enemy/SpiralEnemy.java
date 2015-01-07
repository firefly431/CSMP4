/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity.enemy;

import cs.spaceship.Animation;
import cs.spaceship.entity.Cannon;
import cs.spaceship.entity.SpiralCannon;

/**
 *
 * @author s506571
 */
public class SpiralEnemy extends LineEnemy {
    public static final Animation ANIM = new Animation("octopus%d.png", 2, Animation.fromFPS(15));

    public SpiralEnemy(int velocity) {
        super(velocity);
        animator = ANIM.new Animator();
    }
    @Override
    public void equip(Cannon c) {
        super.equip(c);
        if (c instanceof SpiralCannon) {
            ((SpiralCannon)c).vely = velocity;
        }
    }
}
