// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Peyton Dexter (peytond)

// package
package towerofhanoi;

// imports
import CS2114.Shape;
import java.awt.*;
import student.TestableRandom;

/**
 * @author Peyton Dexter
 * @version 3.8.2020
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * 4 param calling super constructor
     * 
     * @param width
     *            int of width
     */
    public Disk(int width) {

        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);

        TestableRandom t = new TestableRandom();

        setBackgroundColor(new Color(t.nextInt(225), t.nextInt(225), t.nextInt(
            225)));
    }


    @Override
    /**
     * comparing disk objects
     * 
     * @param d
     *            disk object
     * @return int negative if smaller, 0 if same, positive if bigger
     */
    public int compareTo(Disk d) {
        if (d == null) {
            throw new IllegalArgumentException();
        }
        if (d.getWidth() > getWidth()) {
            return -1;
        }
        else if (d.getWidth() < getWidth()) {
            return 1;
        }
        else {
            return 0;
        }
    }


    /**
     * returns the disks to string
     * 
     * @return disks height as a string
     */
    public String toString() {
        StringBuilder str1 = new StringBuilder();
        str1.append(getWidth());
        return str1.toString();
    }


    /**
     * Equals method
     * 
     * @param obj
     *            object to test equality
     * @return boolean t/f
     */
    public boolean equals(Object obj) {
        // check same
        if (obj == this) {
            return true;
        }
        // check null
        if (obj == null) {
            return false;
        }
        // check class
        if (obj.getClass() == this.getClass()) {
            Disk objTwo = (Disk)obj;

            if (objTwo.getWidth() == this.getWidth()) {
                return true;
            }
        }
        return false;
    }

}
