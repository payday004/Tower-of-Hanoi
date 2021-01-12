// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Peyton Dexter (peytond)

package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * @author Peyton Dexter
 * @version 3.24.2020
 */
public class LinkedStackTest extends TestCase {

    // fields
    private LinkedStack<String> s1;
    private LinkedStack<String> stringTo;

    /**
     * sets up each test before each run
     */
    public void setUp() {
        s1 = new LinkedStack<>();

        stringTo = new LinkedStack<>();
        stringTo.push("popcorn");
        stringTo.push("pizza");
        stringTo.push("popsicle");
    }


    /**
     * tests push method
     */
    public void testPush() {
        assertTrue(s1.isEmpty());

        s1.push("pizza");
        s1.push("popcorn");

        assertFalse(s1.isEmpty());
        assertEquals(s1.size(), 2);
    }


    /**
     * tests size method
     */
    public void testSize() {
        assertEquals(s1.size(), 0);

        s1.push("pizza");
        s1.push("popcorn");

        assertEquals(s1.size(), 2);
    }


    /**
     * tests the isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(s1.isEmpty());
        s1.push("pizza");
        assertFalse(s1.isEmpty());
    }


    /**
     * tests peek method
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            s1.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

        s1.push("pizza");

        assertEquals(s1.peek(), "pizza");
    }


    /**
     * tests pop method
     */
    public void testPop() {
        Exception thrown = null;
        try {
            s1.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

        s1.push("pizza");

        assertEquals(s1.pop(), "pizza");
    }


    /**
     * tests toString method
     */
    public void testToString() {
        assertEquals(stringTo.toString(), "[popsicle, pizza, popcorn]");
        // System.out.println(diskStack.toString());
        stringTo.clear();
        assertEquals(stringTo.toString(), "[]");
    }


    /**
     * tests clear method
     */
    public void testClear() {
        assertFalse(stringTo.isEmpty());
        // System.out.println(stringTo.toString());
        stringTo.clear();
        // System.out.println(stringTo.toString());
        assertTrue(stringTo.isEmpty());
    }

}
