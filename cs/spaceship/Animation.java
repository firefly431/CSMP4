/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.spaceship;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author s506571
 */
public class Animation {
    private int length;
    private int speed;
    private BufferedImage images[];
    // format is a printf-style format string
    // will pass integers 0..length-1
    // speed is the number of timer ticks per frame
    public Animation(String format, int length, int speed) {
        this.length = length;
        this.speed = speed;
        images = new BufferedImage[length];
        try {
            for (int i = 0; i < length; i++)
                images[i] = ImageIO.read(Animation.class.getClassLoader().getResourceAsStream(String.format(format, i)));
        } catch (IOException e) {
            throw new RuntimeException("Unable to load animation: " + e.getMessage());
        }
    }

    public static int fromFPS(double fps) {
        return (int)(GamePanel.FPS / fps);
    }

    public class Animator {
        int frame = 0;
        int timer = 0;
        public Animator() {
            reset();
        }

        public void reset() {
            frame = timer = 0;
        }

        public synchronized void animate() {
            timer++;
            if (timer >= speed) {
                timer = 0;
                frame++;
                if (frame >= length) {
                    frame = 0;
                }
            }
        }

        public synchronized BufferedImage get() {
            return images[frame];
        }
    }
}
