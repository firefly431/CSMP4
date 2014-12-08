/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// TODO: MUSIC http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html

package cs.spaceship;

import cs.geom.Vector2D;
import cs.spaceship.entity.Bullet;
import cs.spaceship.entity.EntityGroup;
import cs.spaceship.entity.Spaceship;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

/**
 */
public class GamePanel extends ControllableStatePanel implements ActionListener {
    Spaceship player;
    public EntityGroup<Bullet> bullets;
    Timer stepTimer;

    public GamePanel() {
        // player
        player = new Spaceship();
        player.setController(getController());
        // bullets
        bullets = new EntityGroup<Bullet>();
        // center player on screen
        player.setPosition(new Vector2D(GameFrame.WINDOW_WIDTH / 2, GameFrame.WINDOW_HEIGHT / 2));
        stepTimer = new Timer(30, this);
        stepTimer.start();
    }
    
    // timer event
    public void actionPerformed(ActionEvent e) {
        player.update();
        bullets.update();
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
        bullets.draw(g);
    }
}
