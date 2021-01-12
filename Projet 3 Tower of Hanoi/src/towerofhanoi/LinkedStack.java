// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Peyton Dexter (peytond)

// package
package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

/**
 * @author Peyton Dexter
 * @version 3.20.2020
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {

    // fields
    private Node<T> topNode;
    private int size;

    /**
     * linked stack constructor
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * size getter method
     * 
     * @return size of stack
     */
    public int size() {
        return size;
    }


    @Override
    /**
     * is empty method
     * 
     * @retrun if stack is empty or not
     */
    public boolean isEmpty() {

        return size == 0;
    }


    @Override
    /**
     * top note data getter method
     * 
     * @return topNodes data
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    @Override
    /**
     * pushes an entry onto the top of the stack
     * 
     * @param anEntry
     *            Data being pushed
     */
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry);
        newNode.setNextNode(topNode);
        topNode = newNode;
        size++;
    }


    @Override
    /**
     * removes node on top of stack
     * 
     * @return data of top node
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> localNode = topNode;
        topNode = topNode.getNextNode();
        size--;
        return localNode.getData();
    }


    /**
     * linked stacks toString method
     * 
     * @return tostring, data of all nodes
     */
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder str = new StringBuilder();
        str.append("[");

        int refSize = size;
        Node<T> refNode = topNode;

        while (refSize > 0) {
            str.append(refNode.getData());
            if (refSize > 1) {
                str.append(", ");
            }
            refNode = refNode.next;
            refSize--;
        }

        str.append("]");
        return str.toString();
    }


    @Override
    /**
     * clear method, disconnects top node from linked stack
     */
    public void clear() {
        topNode = null;
        size = 0;
    }

    // private class NODE<T>
    @SuppressWarnings("hiding")
    private class Node<T> {

        // fields
        private Node<T> next;
        private T data;

        /**
         * Node one argument constructor
         * 
         * @param dataIn
         *            data that the node contains
         */
        public Node(T dataIn) {
            this(dataIn, null);
        }


        /**
         * Node 2 arg constructor
         * 
         * @param dataIn
         *            data to be stored in node
         * @param node
         *            node that this node is linked to
         */
        public Node(T dataIn, Node<T> node) {
            data = dataIn;
            next = node;
        }


        /**
         * Next node Getter method
         * 
         * @return reference to next node
         */
        public Node<T> getNextNode() {
            return next;
        }


        /**
         * Getter for the nodes data field
         * 
         * @return data of type <T> that is stored in node
         */
        public T getData() {
            return data;
        }


        /**
         * setter for next node
         * 
         * @param node
         *            node that is being set to next node
         */
        public void setNextNode(Node<T> node) {
            next = node;
        }

    }

}
