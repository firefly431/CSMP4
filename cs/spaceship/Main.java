/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship;

/**
 *
 * @author s506571
 */
public class Main {
    public static void main(String argv[]) {
        GameFrame mf = new GameFrame();
        mf.init();
        mf.transition(new GamePanel());
        mf.pack();
        mf.setVisible(true);
    }
}
