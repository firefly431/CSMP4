/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// TODO: MUSIC http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html

package cs.spaceship;

import cs.geom.Vector2D;
import cs.spaceship.entity.Bullet;
import cs.spaceship.entity.Cannon;
import cs.spaceship.entity.CircleCannon;
import cs.spaceship.entity.enemy.Enemy;
import cs.spaceship.entity.EntityGroup;
import cs.spaceship.entity.Spaceship;
import cs.spaceship.entity.SpiralCannon;
import cs.spaceship.entity.enemy.DefaultEnemyFactory;
import cs.spaceship.entity.enemy.EnemyFactory;
import cs.spaceship.entity.enemy.FactoryMultiplier;
import cs.spaceship.entity.enemy.SideToSideEnemy;
import cs.spaceship.entity.enemy.WavyEnemy;
import cs.spaceship.entity.enemy.ZigZagEnemy;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

/**
 */
public class GamePanel extends ControllableStatePanel implements ActionListener {
    Spaceship player;
    public EntityGroup<Bullet> bullets;
    public EntityGroup<Enemy> enemies;
    public EntityGroup<Spaceship> playerG;
    Timer stepTimer;
    public static final int FPS = 60;

    public GamePanel() {
        // bullets
        bullets = new EntityGroup<Bullet>();
        // enemies
        enemies = new EntityGroup<Enemy>();
        // player
        playerG = new EntityGroup<Spaceship>();
        // center player on screen
    }

    public void init() {
        player = new Spaceship(enemies);
        player.setController(getController());
        playerG.add(player);
        player.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2, GameFrame.WINDOW_HEIGHT - 100));
        stepTimer = new Timer(1000 / FPS, this);
        stepTimer.start();
        // make enemies
        enemies.add(
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
        enemies.add(
                new FactoryMultiplier(
                new DefaultEnemyFactory(), 8).buildArray());
        ZigZagEnemy zig1 = new ZigZagEnemy(20, 1, 1), zig2 = new ZigZagEnemy(20, -1, 1);
        zig1.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2 + 80, 100));
        zig2.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2 - 80, 100));
        zig1.equip(new CircleCannon(new Bullet(0, 0, 12, 0, 8, Color.MAGENTA, playerG), 70, 8));
        zig2.equip(new CircleCannon(new Bullet(0, 0, 12, 0, 8, Color.MAGENTA, playerG), 70, 8));
        enemies.add(zig1);
        enemies.add(zig2);
        WavyEnemy wave = new WavyEnemy(100, 4, GameFrame.WINDOW_WIDTH / 3, GameFrame.WINDOW_WIDTH / 2);
        wave.equip(new SpiralCannon(new Bullet(0, 0, 10, 0, 6, Color.PINK, playerG), 20, Math.PI / 2, 16));
        ((SpiralCannon)wave.getCannon()).vely = wave.velocity;
        enemies.add(wave);
    }
    
    // timer event
    public void actionPerformed(ActionEvent e) {
        enemies.update();
        bullets.update();
        player.update();
        // repaint, done updating
        repaint();
    }

    @Override
    public void removed() {
        stepTimer.stop();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GameFrame.WINDOW_WIDTH, GameFrame.WINDOW_HEIGHT);
        player.draw(g);
        enemies.draw(g);
        bullets.draw(g);
    }
}
