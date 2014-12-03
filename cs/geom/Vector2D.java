/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.geom;

/**
 *
 * @author s506571
 */
public class Vector2D {
    public int x, y;

    public Vector2D(int x, int y) {
        set(x, y);
    }

    public Vector2D() {
        this(0, 0);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void invert() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public Vector2D inverse() {
        return new Vector2D(-this.x, -this.y);
    }

    public Vector2D plus(Vector2D v) {
        return new Vector2D(x + v.x, y + v.y);
    }

    public Vector2D minus(Vector2D v) {
        return this.plus(v.inverse());
    }

    public Vector2D times(double fac) {
        return new Vector2D((int)(x * fac), (int)(y * fac));
    }

    public void set(Vector2D v) {
        x = v.x;
        y = v.y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector2D other = (Vector2D) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.x;
        hash = 47 * hash + this.y;
        return hash;
    }
}
