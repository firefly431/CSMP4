/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.geom;

/**
 *
 * @author s506571
 */
public class AABB {
    private Vector2D p1, p2;

    public AABB(int x1, int y1, int x2, int y2) {
        this(new Vector2D(x1, y1),
             new Vector2D(x2, y2));
    }

    public AABB(AABB other) {
        this(other.p1, other.p2);
    }

    public AABB(Vector2D p1, Vector2D p2) {
        set(p1, p2);
    }

    public AABB(int width, int height) {
        this(0, 0, width, height);
    }

    public boolean intersects(AABB other) {
        return (
            p1.x <= other.p2.x && other.p1.x <= p2.x &&
            p1.y <= other.p2.y && other.p1.y <= p2.y
        );
    }

    public void set(Vector2D p1, Vector2D p2) {
        this.p1 = new Vector2D(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
        this.p2 = new Vector2D(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y));
    }

    public void moveTo(Vector2D topLeft) {
        set(topLeft, topLeft.plus(this.p2.minus(this.p1)));
    }

    public void moveTo(int x, int y) {
        moveTo(new Vector2D(x, y));
    }

    public void center(Vector2D center) {
        // preserve size!
        moveTo(center.minus(p2.minus(p1).times(0.5)));
    }

    public Vector2D getTopLeft() {
        return new Vector2D(p1);
    }

    public Vector2D getBottomRight() {
        return new Vector2D(p2);
    }

    public Vector2D getCenter() {
        return p1.plus(p2).times(0.5);
    }

    @Override
    public String toString() {
        return p1.toString() + " " + p2.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AABB other = (AABB) obj;
        if (this.p1 != other.p1 && (this.p1 == null || !this.p1.equals(other.p1))) {
            return false;
        }
        if (this.p2 != other.p2 && (this.p2 == null || !this.p2.equals(other.p2))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.p1 != null ? this.p1.hashCode() : 0);
        hash = 71 * hash + (this.p2 != null ? this.p2.hashCode() : 0);
        return hash;
    }

    public Vector2D getSize() {
        return p2.minus(p1);
    }
}
