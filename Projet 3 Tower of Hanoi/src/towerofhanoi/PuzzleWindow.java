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
import CS2114.Window;
import CS2114.WindowSide;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;

/**
 * @author Peyton Dexter
 * @version 3.20.2020
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {

    // Fields
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    private HanoiSolver game;

    // Constants
    static final int WIDTH_FACTOR = 10;
    static final int DISK_GAP = 5;
    static final int DISK_HEIGHT = 10;

    /**
     * PuzzleWindow constructor
     * 
     * @param game1
     *            Hanoi Solver object
     */
    public PuzzleWindow(HanoiSolver game1) {

        // Hanoi solver connector
        game = game1;
        game.addObserver(this);

        // window constructor
        window = new Window("Tower of Hanoi");

        // making the Towers
        left = new Shape(80, 100, 10, 200, Color.DARK_GRAY);
        middle = new Shape(280, 100, 10, 200, Color.DARK_GRAY);
        right = new Shape(480, 100, 10, 200, Color.DARK_GRAY);

        // adding disks
        for (int i = game.disks(); i > 0; i--) {
            Disk a = new Disk(14 * i);
            window.addShape(a);
            game.getTower(Position.RIGHT).push(a);
            moveDisk(Position.RIGHT);
        }

        window.addShape(right);
        window.addShape(left);
        window.addShape(middle);

        Button solveButton = new Button("solve");
        window.addButton(solveButton, WindowSide.SOUTH);
        solveButton.onClick(this, "clickedSolve");
    }


    /**
     * update method
     * 
     * @param obs
     *            parameter of type Observable
     * @param obj
     *            parameter of type Object
     */
    public void update(Observable obs, Object arg) {
        if (arg.getClass().equals(Position.class)) {
            moveDisk((Position)arg);
            sleep();
        }
    }


    // helper method sleep
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * Method that is connected to the solve button
     * 
     * @param button
     *            solve button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    // helper method move disk
    private void moveDisk(Position p) {
        Disk currentDisk;
        Shape currentPole;

        currentDisk = game.getTower(p).peek();

        if (p == Position.LEFT) {
            currentPole = left;
        }
        else if (p == Position.RIGHT) {
            currentPole = right;
        }
        else {
            currentPole = middle;
        }

        currentDisk.moveTo(currentPole.getX() - currentDisk.getWidth() / 2 + 5,
            300 - game.getTower(p).size() * DISK_HEIGHT);
    }

}
