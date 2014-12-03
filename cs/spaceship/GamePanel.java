/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// TODO: MUSIC http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html

package cs.spaceship;

import java.awt.*;
import java.awt.event.*;

import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.Timer;

/**
 */
public class GamePanel extends ControllableStatePanel implements ActionListener {
    Spaceship player;
    Timer stepTimer;

    public GamePanel() {
        // player
        player = new Spaceship();
        player.setController(getController());
        // center player on screen
        player.position.set(GameFrame.WINDOW_WIDTH / 2, GameFrame.WINDOW_HEIGHT / 2);
        stepTimer = new Timer(30, this);
        stepTimer.start();
    }
    
    // timer event
    public void actionPerformed(ActionEvent e) {
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
    }
}
