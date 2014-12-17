/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship.entity;

import cs.spaceship.entity.enemy.Enemy;
import cs.geom.AABB;
import cs.geom.Vector2D;
import cs.spaceship.Animation;
import cs.spaceship.Controller;
import cs.spaceship.GameFrame;
import cs.spaceship.GamePanel;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author s506571
 */
public class Spaceship extends Entity implements Targetable {
    public static final Animation ANIM = new Animation("xwing%d.png", 2, GamePanel.FPS / (1000 / 100));
    private Animation.Animator animator;

    public static final int HORIZONTAL_SPEED = 12;
    public static final int VERTICAL_SPEED = 8;

    public static final int BULLET_OFFSET_X = 38;
    public static final int BULLET_OFFSET_Y = -45;
    public static final int BULLET_RADIUS = 6;
    public static final int BULLET_SPEED = -15;
    public static final int BULLET_FIRE_RATE = 12;

    protected Cannon leftCannon, rightCannon;

    @Override
    public int COLLISION_WIDTH() {
        return 26;
    }
    @Override
    public int COLLISION_HEIGHT() {
        return 86;
    }

    public Spaceship(EntityGroup<Enemy> target) {
        animator = ANIM.new Animator();
        position = new Vector2D();
        leftCannon = new Cannon(new Bullet(
            position.x - BULLET_OFFSET_X,
            position.y + BULLET_OFFSET_Y,
            BULLET_RADIUS,
            0, BULLET_SPEED,
            Color.RED.darker().brighter(),
            target
        ), BULLET_FIRE_RATE);
        rightCannon = new Cannon(new Bullet(
            position.x + BULLET_OFFSET_X,
            position.y + BULLET_OFFSET_Y,
            BULLET_RADIUS,
            0, BULLET_SPEED,
            Color.RED.darker().brighter(),
            target
        ), BULLET_FIRE_RATE);
    }

    @Override
    public void update() {
        int dx = 0;
        int dy = 0;
        if (isPressed(Controller.Key.LEFT))
            dx -= HORIZONTAL_SPEED;
        if (isPressed(Controller.Key.RIGHT))
            dx += HORIZONTAL_SPEED;
        if (isPressed(Controller.Key.UP))
            dy -= VERTICAL_SPEED;
        if (isPressed(Controller.Key.DOWN))
            dy += VERTICAL_SPEED;
        if (isPressed(Controller.Key.FIRE)) {
            leftCannon.fire();
            rightCannon.fire();
        }
        position.add(dx, dy);
        AABB aabb = getAABB();
        // collide with edges
        Vector2D tl = aabb.getTopLeft();
        Vector2D br = aabb.getBottomRight();
        if (tl.x < 0)
            tl.x = 0;
        if (tl.y < 0)
            tl.y = 0;
        if (br.x >= GameFrame.WINDOW_WIDTH)
            tl.x = GameFrame.WINDOW_WIDTH - COLLISION_WIDTH();
        if (br.y >= GameFrame.WINDOW_HEIGHT)
            tl.y = GameFrame.WINDOW_HEIGHT - COLLISION_HEIGHT();
        aabb.moveTo(tl);
        position.set(aabb.getCenter());
        leftCannon.setBasePosition(position);
        rightCannon.setBasePosition(position);
        // advance bullet timer
        leftCannon.update();
        rightCannon.update();
        // animate
        animator.animate();
    }

    @Override
    public void draw(Graphics g) {
        Image img = animator.get();
        g.drawImage(img, position.x - img.getWidth(null) / 2, position.y - img.getWidth(null) / 2, null);
    }

    @Override
    public void hitByBullet() {
        System.out.println("Player was hit!");
    }
}
