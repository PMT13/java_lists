// IntNodeOrder.java
// Revised February 2020

// Creates an ordered list (from low to high) of integers
// Uses IntNode.java for the individual nodes in the linked list

// What happens when the "adding" to the list is done in a
// separate method such as public void add(IntNode start, int value)?
// Does it still work?  Try it by writing a separate add()
// method in place of adding the elements directly in main().

import java.util.Scanner;

public class IntNodeOrder {
    
    public static void main(String[] args) {

        // Tests the IntNode class by building a sorted list of ints

        // Three cases when adding to a list in sorted order:  
        //  1)  Adding to an empty list
        //  2)  Adding to the very beginning of a (non-empty) list
        //  3)  Adding somewhere after the first item of a list

        IntNode start = null;
        IntNode ptr, trailer;
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer (enter a non-int to quit): ");
        if (s.hasNextInt()) {  // add to empty list special case
          start = new IntNode(s.nextInt(), null);
        }  // add to empty list special case
        
        System.out.print("Enter next integer (enter a non-int to quit): ");
        while (s.hasNextInt()) {
            int temp = s.nextInt();
            System.out.println("Get data: "+start.getData());
            System.out.println("Get next: "+start.getNext());
            if (start.getData() > temp) {  // special case add at start
                start = new IntNode(temp, start);
                System.out.println("Bye");
            }else {  // general case
                System.out.println("Hi");
              ptr = start.getNext();
              if(ptr == null){
                  System.out.println("True");
              }
              trailer = start;
              while (ptr != null && ptr.getData() < temp) {
                  System.out.println("We in!");
                  trailer = ptr;
                  ptr = ptr.getNext();
              }  // find location for new item in list
                System.out.println("Get next0: "+start.getNext());
              trailer.setNext(new IntNode(temp, ptr));
                System.out.println("Get next1: "+start.getNext());
            }  // general case
            System.out.print("Next integer (non-int to quit): ");
        }  // while input loop

        System.out.println("\nThe sorted list of ints ...");
        ptr = start;
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }

    }  // main

}  // IntNodeOrder
