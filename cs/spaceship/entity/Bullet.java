/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

import cs.geom.AABB;
import cs.geom.Vector2D;
import cs.spaceship.GameFrame;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author s544545
 */
public class Bullet extends Entity {
    public int radius;
    public double velx, vely;
    public double posx, posy;
    public Color color;

    public Bullet() {
        position = new Vector2D();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setVelocity(double x, double y) {
        this.velx = x;
        this.vely = y;
    }

    public void setPosition(double px, double py) {
        this.posx = px;
        this.posy = py;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void update() {
        posx += velx;
        posy += vely;
        position.set((int)posx, (int)posy);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)posx - radius, (int)posy - radius, radius * 2, radius * 2);
        g.setColor(Color.WHITE);
        g.fillOval((int)posx - radius * 2 / 3, (int)posy - radius * 2 / 3, radius * 2 / 3 * 2, radius * 2 / 3 * 2);
    }

    @Override
    public boolean shouldDelete() {
        return !(new AABB(GameFrame.WINDOW_WIDTH, GameFrame.WINDOW_HEIGHT).intersects(getAABB()));
    }

    @Override
    public int COLLISION_WIDTH() {
        return radius * 2;
    }

    @Override
    public int COLLISION_HEIGHT() {
        return radius * 2;
    }
}
