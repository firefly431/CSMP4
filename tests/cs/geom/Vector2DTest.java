/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tests.cs.geom;

import cs.geom.Vector2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author s506571
 */
public class Vector2DTest {

    public Vector2DTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * Test of set method, of class Vector2D.
     */
    @Test
    public void testSet_int_int() {
        System.out.println("set");
        int x = 0;
        int y = 0;
        Vector2D instance = new Vector2D();
        instance.set(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Vector2D.
     */
    @Test
    public void testAdd_int_int() {
        System.out.println("add");
        int x = 0;
        int y = 0;
        Vector2D instance = new Vector2D();
        instance.add(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Vector2D.
     */
    @Test
    public void testAdd_Vector2D() {
        System.out.println("add");
        Vector2D v = null;
        Vector2D instance = new Vector2D();
        instance.add(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invert method, of class Vector2D.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        Vector2D instance = new Vector2D();
        instance.invert();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inverse method, of class Vector2D.
     */
    @Test
    public void testInverse() {
        System.out.println("inverse");
        Vector2D instance = new Vector2D();
        Vector2D expResult = null;
        Vector2D result = instance.inverse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class Vector2D.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Vector2D v = null;
        Vector2D instance = new Vector2D();
        Vector2D expResult = null;
        Vector2D result = instance.plus(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minus method, of class Vector2D.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Vector2D v = null;
        Vector2D instance = new Vector2D();
        Vector2D expResult = null;
        Vector2D result = instance.minus(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class Vector2D.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        double fac = 0.0;
        Vector2D instance = new Vector2D();
        Vector2D expResult = null;
        Vector2D result = instance.times(fac);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Vector2D.
     */
    @Test
    public void testSet_Vector2D() {
        System.out.println("set");
        Vector2D v = null;
        Vector2D instance = new Vector2D();
        instance.set(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Vector2D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vector2D instance = new Vector2D();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}