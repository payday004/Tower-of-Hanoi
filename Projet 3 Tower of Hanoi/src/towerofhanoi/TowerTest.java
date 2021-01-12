// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Peyton Dexter (peytond)

package towerofhanoi;

import student.TestCase;

/**
 * @author Peyton Dexter
 * @version 3.24.2020
 */
public class TowerTest extends TestCase {

    //fields
    private Tower t1;

    /**
     * sets up methods before they run
     */
    public void setUp() {

        t1 = new Tower(Position.DEFAULT);
    }


    /**
     * tests the push method
     */
    public void testPush() {

        Disk nullDisk = null;
        Disk d1 = new Disk(5);
        Disk d2 = new Disk(10);
        Disk d3 = new Disk(15);

        assertTrue(t1.isEmpty());

        Exception thrown = null;
        try {
            t1.push(nullDisk);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        t1.push(d2);
        assertEquals(t1.size(), 1);
        t1.push(d1);
        assertEquals(t1.size(), 2);

        Exception thrown2 = null;
        try {
            t1.push(d3);
        }
        catch (Exception exception1) {
            thrown2 = exception1;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IllegalStateException);
    }


    /**
     * tests position method
     */
    public void testPosition() {

        assertEquals(t1.position(), Position.DEFAULT);
    }

}
