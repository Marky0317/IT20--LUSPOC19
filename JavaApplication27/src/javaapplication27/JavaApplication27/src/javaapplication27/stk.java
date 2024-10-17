 
package javaapplication27;
import java.util.Stack;



public class stk {
    public static void main(String[] args) {

        Stack<Integer> hahaha = new Stack<>();
        
        // Push elements onto the stack
        hahaha.push(10);
        hahaha.push(20);
        hahaha.push(30);

        System.out.println("Stack: " +hahaha);

        // Pop and display the top element
        int topElement = hahaha.pop();
        System.out.println("okay Popped: " + topElement);
        
        // Peek at the top element without removing it
        int peekedElement = hahaha.peek();
        System.out.println("okay kaayo Peeked: " + peekedElement);

        // Check if the stack is empty
        boolean isEmpty = hahaha.isEmpty();
        System.out.println("Is Stack Empty? " + isEmpty);

        // Get the size of the stack
        int stackSize = hahaha
                .size();
        System.out.println("Stack Size: " + stackSize);
    }
}

