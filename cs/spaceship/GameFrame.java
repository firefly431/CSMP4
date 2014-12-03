package cs.spaceship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs.spaceship.resources.Music;

/**
 * Main game window. Contains menu panel or board panel.
 */
public class GameFrame extends JFrame {
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;
    private StatePanel currentPanel;

    // allow other classes to access the main frame
    private static GameFrame mainFrame = null;

    public static GameFrame get() {
        return mainFrame;
    }

    public GameFrame() {
        super("Spaceship!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        if (mainFrame != null) {
            throw new RuntimeException("More than one GameFrame");
        }
        mainFrame = this;
    }
    
    /**
     * Initialize components and game
     */
    public void init() {
        currentPanel = null;
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_M) {
                    boolean v;
                    do {
                        v = Music.global_mute.get();
                    } while (!Music.global_mute.compareAndSet(v, !v));
                    updateTitle(!v);
                }
            }

            public void keyReleased(KeyEvent e) {}
        });
        pack();
        updateTitle(false);
    }

    protected void updateTitle(boolean mute) {
        setTitle("Spaceship! - Press M to " + (mute ? "unmute" : "mute"));
    }

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    /**
     * Transition to another panel
     *
     * Removes current panel, if any, and adds the target panel and its
     * KeyListener.
     * @param target Target JPanel, must be a KeyListener
     */
    public void transition(StatePanel target) {
        if (currentPanel == target)
            return;
        if (currentPanel != null) {
            remove(currentPanel);
            removeKeyListener(currentPanel);
            currentPanel.removed();
        }
        currentPanel = target;
        getContentPane().add(currentPanel);
        addKeyListener(currentPanel);
        currentPanel.revalidate();
        repaint();
    }
}
