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
import cs.spaceship.waves.*;
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

    public static final Wave[] waves = {
        new Wave1(),
        new Wave1()
    };
    private int wave = 0;

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
        if (enemies.size() == 0 && bullets.size() == 0)
            nextWave();
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

    protected void nextWave() {
        if (wave < waves.length) {
            player.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2, GameFrame.WINDOW_HEIGHT - 100));
            enemies.clear();
            bullets.clear();
            waves[wave++].generateEnemies(enemies, playerG);
        } else {
            // YOU WIN!
        }
    }
}
