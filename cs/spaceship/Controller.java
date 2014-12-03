/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumMap;

/**
 *
 * @author s506571
 */
public class Controller implements KeyListener {
    public enum Key {
        // modify this class to modify keys to listen to
        LEFT(KeyEvent.VK_LEFT), RIGHT(KeyEvent.VK_RIGHT),
        UP(KeyEvent.VK_UP), DOWN(KeyEvent.VK_DOWN),
        FIRE(KeyEvent.VK_SPACE);

        private int code;

        private Key(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static Key getFromCode(int code) {
            for (Key k : values()) {
                if (k.getCode() == code)
                    return k;
            }
            return null;
        }
    }

    private EnumMap<Key, Boolean> pressed;

    public Controller() {
        pressed = new EnumMap<Key, Boolean>(Key.class);
        for (Key k : Key.values())
            pressed.put(k, false);
    }

    public void keyTyped(KeyEvent e) {
        // don't care
    }

    public void keyPressed(KeyEvent e) {
        Key k = Key.getFromCode(e.getKeyCode());
        if (k != null)
            pressed.put(k, true);
    }

    public void keyReleased(KeyEvent e) {
        Key k = Key.getFromCode(e.getKeyCode());
        if (k != null)
            pressed.put(k, false);
    }

    public boolean isPressed(Key e) {
        return pressed.get(e);
    }
}
