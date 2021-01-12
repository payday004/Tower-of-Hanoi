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
public class DiskTest extends TestCase {

    private Disk d1;
    private Disk d2;
    private Disk d3;
    private Disk d;
    

    /**
     * sets up tests before each run
     */
    public void setUp() {

        d1 = new Disk(5);
        d2 = new Disk(10);
        d3 = new Disk(15);
        d = new Disk(10);
    }


    /**
     * tests compare to method
     */
    public void testCompareTo() {
        Disk dNull = null;
        
        Exception thrown = null;
        try {
            d1.compareTo(dNull);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        assertEquals(d1.compareTo(d2), -1);
        assertEquals(d3.compareTo(d2), 1);
        assertEquals(d.compareTo(d2), 0);
    }


    /**
     * tests to string method
     */
    public void testToString() {

        assertEquals(d1.toString(), "5");
    }


    /**
     * tests equals method
     */
    public void testEquals() {

        Disk disk = new Disk(5);

        Disk disk1 = disk; // same
        Disk disk2 = null; // null
        Object disk3 = new Object(); // class
        Disk disk4 = new Disk(5); // equals
        Disk disk5 = new Disk(10); // not equals

        assertTrue(disk.equals(disk1));
        assertFalse(disk.equals(disk2));
        assertFalse(disk.equals(disk3));
        assertTrue(disk.equals(disk4));
        assertFalse(disk.equals(disk5));
    }

}
