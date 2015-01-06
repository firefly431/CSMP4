/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.waves;

import cs.geom.Vector2D;
import cs.spaceship.GameFrame;
import cs.spaceship.entity.Bullet;
import cs.spaceship.entity.Cannon;
import cs.spaceship.entity.CircleCannon;
import cs.spaceship.entity.EntityGroup;
import cs.spaceship.entity.SpiralCannon;
import cs.spaceship.entity.Targetable;
import cs.spaceship.entity.enemy.DefaultEnemyFactory;
import cs.spaceship.entity.enemy.Enemy;
import cs.spaceship.entity.enemy.EnemyFactory;
import cs.spaceship.entity.enemy.FactoryMultiplier;
import cs.spaceship.entity.enemy.LineEnemy;
import cs.spaceship.entity.enemy.SideToSideEnemy;
import cs.spaceship.entity.enemy.ZigZagEnemy;
import java.awt.Color;

/**
 *
 * @author s506571
 */
public class Wave1 implements Wave {
    @Override
    public void generateEnemies(final EntityGroup<Enemy> target, final EntityGroup<? extends Targetable> playerG) {
        target.add(
                new FactoryMultiplier(
                new EnemyFactory() {
                    @Override
                    public Enemy build() {
                        return build(0, 1);
                    }
                    @Override
                    public Enemy build(int p1, int p2) {
                        Enemy ret = new SideToSideEnemy(20, p1 < p2 / 2 ? -1 : 1);
                        ret.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2, 20));
                        ret.equip(new Cannon(new Bullet(0, 0, 4, 0, 4, Color.BLUE, playerG), 40));
                        return ret;
                    }
                }, 4
                ).buildArray());
        target.add(
                new FactoryMultiplier(
                new DefaultEnemyFactory(), 8).buildArray());
        ZigZagEnemy zig1 = new ZigZagEnemy(20, 1, 1), zig2 = new ZigZagEnemy(20, -1, 1);
        //WavyEnemy zig1 = new WavyEnemy(GameFrame.WINDOW_HEIGHT, 2,  GameFrame.WINDOW_WIDTH / 2, GameFrame.WINDOW_WIDTH / 2),
        //          zig2 = new WavyEnemy(GameFrame.WINDOW_HEIGHT, 2, -GameFrame.WINDOW_WIDTH / 2, GameFrame.WINDOW_WIDTH / 2);
        zig1.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2 + 80, 100));
        zig2.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2 - 80, 100));
        zig1.equip(new CircleCannon(new Bullet(0, 0, 6, 0, 8, Color.MAGENTA, playerG), 70, 8));
        zig2.equip(new CircleCannon(new Bullet(0, 0, 6, 0, 8, Color.MAGENTA, playerG), 70, 8));
        target.add(zig1);
        target.add(zig2);
        LineEnemy spiral = new LineEnemy(2);
        spiral.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2, 0));
        spiral.equip(new SpiralCannon(new Bullet(0, 0, 10, 0, 6, Color.PINK, playerG), 20, Math.PI / 2, 16));
        ((SpiralCannon)spiral.getCannon()).vely = spiral.getVelocity();
        target.add(spiral);
    }
}
