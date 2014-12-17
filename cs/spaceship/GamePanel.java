/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// TODO: MUSIC http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html

package cs.spaceship;

import cs.geom.Vector2D;
import cs.spaceship.entity.Bullet;
import cs.spaceship.entity.enemy.Enemy;
import cs.spaceship.entity.EntityGroup;
import cs.spaceship.entity.Spaceship;
import cs.spaceship.entity.enemy.DefaultEnemyFactory;
import cs.spaceship.entity.enemy.EnemyFactory;
import cs.spaceship.entity.enemy.FactoryMultiplier;
import cs.spaceship.entity.enemy.SideToSideEnemy;
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
                        Enemy ret = new SideToSideEnemy();
                        ret.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2, 20));
                        return ret;
                    }
                }, 4
                ).buildArray());
        enemies.add(
                new FactoryMultiplier(
                new DefaultEnemyFactory(), 8).buildArray());
        ZigZagEnemy zig1 = new ZigZagEnemy(), zig2 = new ZigZagEnemy();
        zig1.setPosition(new Vector2D(80, -20));
        zig1.direction = 12;
        zig2.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH - 80, -20));
        zig2.direction = -12;
        enemies.add(zig1);
        enemies.add(zig2);
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
