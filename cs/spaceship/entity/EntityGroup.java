/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

import cs.geom.AABB;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author s506571
 */
public class EntityGroup<E extends Entity> extends Entity {
    @Override
    public int COLLISION_WIDTH() {
        throw new UnsupportedOperationException("Groups do not have size");
    }
    @Override
    public int COLLISION_HEIGHT() {
        throw new UnsupportedOperationException("Groups do not have size");
    }

    private HashSet<E> entities;

    public EntityGroup() {
        entities = new HashSet<E>();
    }

    @Override
    public AABB getAABB() {
        throw new UnsupportedOperationException("Groups do not have AABBs");
    }

    public E getCollidingEntity(AABB other) {
        for (E e : entities) {
            if (e.collidesWith(other))
                return e;
        }
        return null;
    }

    public Entity getDeepCollidingEntity(AABB other) {
        Entity e = getCollidingEntity(other);
        while (e != null && e instanceof EntityGroup<?>) {
            e = ((EntityGroup) e).getCollidingEntity(other);
        }
        return e;
    }

    @Override
    public boolean collidesWith(AABB other) {
        return getCollidingEntity(other) != null;
    }

    @Override
    public void update() {
        for (Iterator<E> it = entities.iterator(); it.hasNext();) {
            E e = it.next();
            if (!e.shouldDelete())
                e.update();
            else
                it.remove();
        }
    }

    @Override
    public void draw(Graphics g) {
        for (Iterator<E> it = entities.iterator(); it.hasNext();) {
            E e = it.next();
            if (!e.shouldDelete())
                e.draw(g);
        }
    }

    public void add(E e) {
        entities.add(e);
    }

    public void add(E[] e) {
        for (E x : e)
            entities.add(x);
    }

    public void remove(E e) {
        entities.remove(e);
    }

    public int size() {
        return entities.size();
    }

    public void clear() {
        entities.clear();
    }
}
