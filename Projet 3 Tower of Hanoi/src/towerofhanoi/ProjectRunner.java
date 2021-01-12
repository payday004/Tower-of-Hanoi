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
public class ProjectRunner {

    /**
     * main method
     * 
     * @param args
     *            string array args
     */
    public static void main(String[] args)
    {
        new PuzzleWindow(new HanoiSolver(Integer.parseInt(args[0])));
    }

}
