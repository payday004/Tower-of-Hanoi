// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Peyton Dexter (peytond)

// package
package towerofhanoi;

// imports
import java.util.Observable;

/**
 * @author Peyton Dexter
 * @version 3.20.2020
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {

    // fields
    private Tower left;
    private Tower right;
    private Tower middle;
    private int numDisks;

    /**
     * Hanoi Solver object constructor
     * 
     * @param numDisk
     *            number of starting disks to solve
     */
    public HanoiSolver(int numDisk) {

        numDisks = numDisk;

        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }


    /**
     * disks method
     * 
     * @return numDisks the number of disks in the puzzle
     */
    public int disks() {
        return numDisks;
    }


    /**
     * getTower method
     * 
     * @param pos
     *            parameter of type Position
     * @return returns a tower
     */
    public Tower getTower(Position pos) {

        if (pos == Position.LEFT) {
            return left;
        }
        else if (pos == Position.RIGHT) {
            return right;
        }
        else {
            return middle;
        }
    }


    /**
     * toString method
     * 
     * @return Sting toString
     */
    public String toString() {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();

        str1.append(left.toString());
        str2.append(middle.toString());
        str3.append(right.toString());

        return str1.toString() + str2.toString() + str3.toString();
    }


    /**
     * uses recursive helper method to solve towers
     */
    public void solve() {
        solveTowers(numDisks, right, middle, left);
    }


    /**
     * Helper method move
     * 
     * @param source
     *            Tower number 1
     * @param destination
     *            Tower number 2
     */
    public void move(Tower source, Tower destination) {
        System.out.println("prepop");
        Disk d = source.pop();
        System.out.println("postpop");
        destination.push(d);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * recursive helper method solve towers
     * 
     * @param currentDisks
     *            int parameter
     * @param startPole
     *            Tower 1 parameter
     * @param tempPole
     *            Tower 2 parameter
     * @param endPole
     *            Tower 3 parameter
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {

        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }

}
