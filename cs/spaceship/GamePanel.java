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
import cs.spaceship.entity.enemy.LineEnemy;
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
    // for some reason it's really slow if FPS is 60
    public static final int FPS = 65;
    public static final int FRAMES_PER_TIMER = 10;
    private long fps_timer = 0;
    private int timer_time = 0;
    double real_fps = FPS;

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
        fps_timer = System.nanoTime();
        stepTimer = new Timer(1000 / FPS, this);
        stepTimer.setCoalesce(false);
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
        LineEnemy spiral = new LineEnemy(2);
        spiral.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2, 0));
        spiral.equip(new SpiralCannon(new Bullet(0, 0, 10, 0, 6, Color.PINK, playerG), 20, Math.PI / 2, 16));
        ((SpiralCannon)spiral.getCannon()).vely = spiral.getVelocity();
        enemies.add(spiral);
    }
    
    // timer event
    public void actionPerformed(ActionEvent e) {
        enemies.update();
        bullets.update();
        player.update();
        // repaint, done updating
        repaint();
        if (++timer_time >= FRAMES_PER_TIMER) {
            timer_time = 0;
            long newtime = System.nanoTime();
            real_fps = 1e9 * FRAMES_PER_TIMER / (newtime - fps_timer);
            fps_timer = newtime;
        }
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
        // draw FPS
        g.setColor(Color.WHITE);
        g.drawString("FPS: " + real_fps, 5, 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if (getController().isPressed(Controller.Key.RESTART))
            GameFrame.get().transition(new GamePanel());
    }

    public void freeze() {
        stepTimer.stop();
    }
}
