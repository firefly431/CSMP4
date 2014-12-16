/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

import cs.geom.Vector2D;
import cs.spaceship.GameFrame;

/**
 *
 * @author s506571
 */
public class ArrowEnemyFactory extends EnemyFactory {
    protected EnemyFactory factory;
    protected int number;
    protected int baseY;
    protected int arrowHeight;

    public ArrowEnemyFactory(EnemyFactory factory, int number, int baseY, int arrowHeight) {
        this.factory = factory;
        this.number = number;
        this.baseY = baseY;
        this.arrowHeight = arrowHeight;
    }

    @Override
    public Enemy build() {
        return factory.build();
    }

    public int getBaseY() {
        return baseY;
    }

    public void setBaseY(int baseY) {
        this.baseY = baseY;
    }

    public void setFactory(EnemyFactory factory) {
        this.factory = factory;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getArrowHeight() {
        return arrowHeight;
    }

    public void setArrowHeight(int arrowHeight) {
        this.arrowHeight = arrowHeight;
    }

    @Override
    public Enemy[] buildArray() {
        Enemy[] ret = new Enemy[number];
        for (int i = 0; i < number; i++) {
            ret[i] = factory.build();
            int y = -Math.abs(i - number / 2);
            y = y * arrowHeight / number;
            y += baseY;
            ret[i].setPosition(new Vector2D(
                    i * GameFrame.WINDOW_WIDTH / number
                    + (GameFrame.WINDOW_WIDTH / number / 2),
                    y));
        }
        return ret;
    }
}
