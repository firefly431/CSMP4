/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship;

import java.awt.event.KeyEvent;

/**
 *
 * @author s506571
 */
public class ControllableStatePanel extends StatePanel {
    private Controller controller;

    public ControllableStatePanel() {
        controller = new Controller();
    }

    public Controller getController() {
        return controller;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        controller.keyReleased(e);
    }
}
