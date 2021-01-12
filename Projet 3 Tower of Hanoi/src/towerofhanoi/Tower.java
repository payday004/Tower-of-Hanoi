// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Peyton Dexter (peytond)

// package
package towerofhanoi;

/**
 * @author Peyton Dexter
 * @version 3.20.2020
 */
public class Tower extends LinkedStack<Disk> {

    // fields
    private Position position;

    /**
     * Tower constructor
     * 
     * @param p
     *            position parameter
     */
    public Tower(Position p) {
        super();
        position = p;
    }


    /**
     * Position Getter Method
     * 
     * @return returns position
     */
    public Position position() {
        return position;
    }


    @Override
    /**
     * push method
     * 
     * @param d
     *            Disk to be pushed onto the tower
     */
    public void push(Disk d) {
        if (d == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || d.compareTo(peek()) == -1) {
            super.push(d);
        }
        else {
            throw new IllegalStateException();
        }
    }


    @Override
    /**
     * toString method for the tower
     * 
     * @return string the super's toString
     */
    public String toString() {
        return super.toString();
    }
}
