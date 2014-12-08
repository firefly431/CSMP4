/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

import cs.geom.*;
import cs.spaceship.Controller;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {
    public static int COLLISION_WIDTH() {
        return 0;
    }
    public static int COLLISION_HEIGHT() {
        return 0;
    }
    protected Vector2D position;

    private Controller controller;

    public AABB getAABB() {
        AABB aabb = new AABB(COLLISION_WIDTH(), COLLISION_HEIGHT());
        aabb.center(position);
        return aabb;
    }

    public Vector2D getPosition() {
        return new Vector2D(position);
    }

    public void setPosition(Vector2D position) {
        this.position = new Vector2D(position);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public boolean isPressed(Controller.Key k) {
        return controller != null && controller.isPressed(k);
    }

    public boolean collidesWith(AABB other) {
        return getAABB().intersects(other);
    }

    /**
     * Called every frame to update the entity.
     * e.g. to move the entity
     *
     * Does nothing by default
     */
    public void update() {}

    /**
     * Called whenever necessary (at least once per frame) to draw the
     * entity on screen.
     *
     * Draws the AABB as a rectangle by default
     * Color is determined by the hashcode of the clsas
     * 
     * @param g The graphics on which to draw
     */
    public void draw(Graphics g) {
        Color c = new Color(this.getClass().hashCode());
        g.setColor(c);
        g.fillRect(getAABB().getTopLeft().x, getAABB().getTopLeft().y, getAABB().getSize().x, getAABB().getSize().y);
    }
}
