/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

import cs.geom.AABB;
import cs.geom.Vector2D;
import cs.spaceship.GameFrame;
import cs.spaceship.GamePanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author s544545
 */
public class Bullet extends DeletableEntity {
    public int radius;
    public double velx, vely;
    public double posx, posy;
    public Color color;
    // if target is set, on update will check for collision and destroy it
    private EntityGroup<? extends DeletableEntity> target;

    public Bullet() {
        target = null;
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
        position.set((int)posx, (int)posy);
    }

    public EntityGroup<? extends Entity> getTarget() {
        return target;
    }

    public void setTarget(EntityGroup<? extends DeletableEntity> target) {
        this.target = target;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void update() {
        posx += velx;
        posy += vely;
        position.set((int)posx, (int)posy);
        if (target != null) {
            DeletableEntity hit = target.getCollidingEntity(getAABB());
            if (hit != null) {
                hit.markForDeletion();
                markForDeletion();
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)posx - radius, (int)posy - radius, radius * 2 + 1, radius * 2 + 1);
        g.setColor(Color.WHITE);
        g.fillOval((int)posx - radius * 2 / 3, (int)posy - radius * 2 / 3, radius * 2 / 3 * 2 + 1, radius * 2 / 3 * 2 + 1);
    }

    @Override
    public boolean shouldDelete() {
        return !(new AABB(GameFrame.WINDOW_WIDTH, GameFrame.WINDOW_HEIGHT).intersects(getAABB()))
                || super.shouldDelete();
    }

    @Override
    public int COLLISION_WIDTH() {
        return (int)(radius * Math.sqrt(2) / 2) * 2 + 1;
    }

    @Override
    public int COLLISION_HEIGHT() {
        return (int)(radius * Math.sqrt(2) / 2) * 2 + 1;
    }

    @Override
    public AABB getAABB() {
        int colsize = (int)(radius * Math.sqrt(2) / 2);
        AABB ret = new AABB(
                new Vector2D((int)(posx - colsize), (int)(posy - colsize)),
                new Vector2D((int)(posx + colsize) + 1, (int)(posy + colsize) + 1)
        );
        return ret;
    }

    public static void fire(double x, double y, int radius, double velx, double vely, Color color) {
        fire(x, y, radius, velx, vely, color, null);
    }

    public static void fire(double x, double y, int radius, double velx, double vely, Color color, EntityGroup<? extends DeletableEntity> target) {
        Bullet b = new Bullet();
        b.setPosition(x, y);
        b.setRadius(radius);
        b.setVelocity(velx, vely);
        b.setColor(color);
        b.setTarget(target);
        ((GamePanel)GameFrame.get().getCurrentPanel()).bullets.add(b);
    }
}
