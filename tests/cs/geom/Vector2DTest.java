/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tests.cs.geom;

import cs.geom.Vector2D;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author s506571
 */
public class Vector2DTest {

    public Vector2DTest() {
        System.out.println("WTF");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Setting up class");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test that setting to 0 works
     */
    @Test
    public void test_set_0() {
        System.out.println("set 0 0");
        for (int i = 0; i < 10; i++) {
            Vector2D instance = new Vector2D((int)(Math.random() * 20 - 10), (int)(Math.random() * 20 - 10));
            instance.set(0, 0);
            Assert.assertEquals(instance.x, 0);
            Assert.assertEquals(instance.y, 0);
        }
    }
}