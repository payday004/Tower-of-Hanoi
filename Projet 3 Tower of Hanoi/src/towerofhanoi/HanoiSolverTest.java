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
public class HanoiSolverTest extends TestCase {

    //fields
    private HanoiSolver hs;
    private HanoiSolver sTest;

    /**
     * sets up methods before each test
     */
    public void setUp() {

        hs = new HanoiSolver(5);
        hs.getTower(Position.LEFT).push(new Disk(30));
        hs.getTower(Position.MIDDLE).push(new Disk(20));
        hs.getTower(Position.RIGHT).push(new Disk(10));
        
        sTest = new HanoiSolver(3);
        sTest.getTower(Position.RIGHT).push(new Disk(30));
        sTest.getTower(Position.RIGHT).push(new Disk(20));
        sTest.getTower(Position.RIGHT).push(new Disk(10));
    }


    /**
     * tests to string method
     */
    public void testToString() {
        assertEquals(hs.toString(), "[30][20][10]");
        // System.out.println(hs.toString());
    }


    /**
     * tests move method
     */
    public void testMove() {
        assertEquals(hs.getTower(Position.RIGHT).size(), 1);
        assertEquals(hs.getTower(Position.LEFT).size(), 1);
        
        //System.out.println(hs.toString());
        hs.move(hs.getTower(Position.RIGHT), hs.getTower(Position.LEFT));
        //System.out.println(hs.toString());
        
        assertTrue(hs.getTower(Position.RIGHT).isEmpty());
        assertEquals(hs.getTower(Position.LEFT).size(), 2);
    }
    
    
    /**
     * tests disks method 
     */
    public void testDisks() {
        assertEquals(hs.disks(), 5);
    }
    
    
    /**
     * tests solveTowers mehtod
     */
    public void testSolveTowers() {        
        assertEquals(sTest.getTower(Position.RIGHT).size(), 3);
        sTest.solve();
        assertEquals(sTest.getTower(Position.LEFT).size(), 3);
    }
    
    
    /**
     * tests solve method 
     */
    public void testSolve() {
        assertEquals(sTest.getTower(Position.RIGHT).size(), 3);
        sTest.solve();
        assertEquals(sTest.getTower(Position.LEFT).size(), 3);
    }
    
    
}
