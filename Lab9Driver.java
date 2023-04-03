/**
 * CSC 112 Lab9 (Linked List Fum) Spring 2023
 * This program tests LinkedList<T> and OrderedLinkedList<T> classes
 *
 * DO NOT CHANGE, github classroom will reference this file
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Apr. 1, 2023
 */

import java.util.Arrays;  

public class Lab9Driver {
    public static void main(String[] args) {
        char testType = processArgs(args);  

        // determine which set of test to sun based on user input
        // 'l' linked, 'o' ordered, 'a' all (both) tests 
        if(testType == 'a' || testType == 'l')
            linkedListTests();
        if(testType == 'a' || testType == 'o')
            orderedListTests();

    }

    /**
     * This method executes a series of LinkedList<T> tests 
     */
    public static void linkedListTests() {
        System.out.println("=================================================");  
        System.out.println("Linked List Tests");  
        var list = new LinkedList<Integer>();
        System.out.println("-------------------------------------------------");  
        System.out.println(".fromArray(array) test");
        Integer[] array = {8, 6, 4, 2};
        System.out.println("array:" + Arrays.toString(array));  
        System.out.println("(BEFORE)list:" + list);  
        list.fromArray(array);
        System.out.println("(AFTER)list:" + list);  

        System.out.println("-------------------------------------------------");  
        System.out.println(".add(index, value) test");
        System.out.println("(BEFORE)list:" + list);  
        list.add(0, 10);
        list.add(list.size() - 1, 20);
        try {
            list.add(30, 50);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("correctly caught IndexOutOfBoundsException");  
        }
        list.add(3, 15);
        list.add(list.size(), 19);
        System.out.println("(AFTER)list:" + list);  

        System.out.println("-------------------------------------------------");  
        System.out.println(".concatenate(other) test");
        System.out.println("(BEFORE)list:" + list);  
        var other = new LinkedList<Integer>();
        System.out.println("(BEFORE)other:" + other);  
        list.concatenate(other);
        System.out.println("(AFTER)list:" + list);  
        other.fromArray(new Integer[]{1, 2, 3});
        System.out.println("(BEFORE)other:" + other);  
        list.concatenate(other);
        System.out.println("(AFTER)list:" + list);  

        System.out.println("-------------------------------------------------");  
        System.out.println("iterator test");
        for(var value: list)
            System.out.print(value + " ");
        System.out.println("");  
        System.out.println("-------------------------------------------------");  

        System.out.println("fin");  
        System.out.println("=================================================");  
    }


    /**
     * This method executes a series of OrderedLinkedList<T> tests 
     */
    public static void orderedListTests() {
        System.out.println("\n=================================================");  
        System.out.println("Ordered List Tests");  
        var orderedList = new OrderedLinkedList<Integer>();
        System.out.println("-------------------------------------------------");  
        System.out.println(".fromArray(array) test");
        System.out.println("(BEFORE)orderedList:" + orderedList);  
        Integer[] array = {1, 9, 7, 2};
        System.out.println("array:" + Arrays.toString(array));  
        orderedList.fromArray(array);
        System.out.println("(AFTER)orderedList:" + orderedList);  

        System.out.println("-------------------------------------------------");  
        System.out.println(".fromLinkedList(list) test");
        var list = new LinkedList<Integer>();
        System.out.println("(BEFORE)orderedList:" + orderedList);  
        list.fromArray(new Integer[]{1, 8, 4, 8});
        System.out.println("list:" + list);  
        orderedList.fromLinkedList(list);
        System.out.println("(AFTER)orderedList:" + orderedList);  

        System.out.println("-------------------------------------------------");  
        System.out.println(".add(value) test");
        orderedList = new OrderedLinkedList<Integer>();
        System.out.println("(BEFORE)orderedList:" + orderedList);  
        orderedList.add(1);
        orderedList.add(0);
        orderedList.add(9);
        orderedList.add(10);
        orderedList.add(5);
        System.out.println("(AFTER)orderedList:" + orderedList);  
        
        System.out.println("-------------------------------------------------");  
        System.out.println(".add(otherList) test");
        System.out.println("(BEFORE)orderedList:" + orderedList);  
        var other = new LinkedList<Integer>();
        other.fromArray(new Integer[]{0, 2, 12});
        System.out.println("(BEFORE)otherList:" + other);  
        orderedList.add(other);
        System.out.println("(AFTER)orderedList:" + orderedList);  

        System.out.println("-------------------------------------------------");  
        System.out.println(".bubbleSort() test");
        orderedList = new OrderedLinkedList<Integer>();
        orderedList.addLast(8);
        orderedList.addLast(6);
        orderedList.addLast(4);
        System.out.println("(BEFORE)orderedList:" + orderedList);  
        orderedList.bubbleSort();
        System.out.println("(AFTER)orderedList:" + orderedList);  

        System.out.println("-------------------------------------------------");  
        System.out.println("iterator test");
        for(var value: orderedList)
            System.out.print(value + " ");
        System.out.println("");  

        System.out.println("fin");  
        System.out.println("=================================================");  
    }


   /**
     * This method parses the user input and returns the test type
     *
     * @param args list of command line argument
     * @return 'l' for list tests, 'o' for ordered tests, 'a' for all (both) tests
     */ 
    public static char processArgs(String[] args) {
        char testType = 'a';
        if(args.length > 0 && args[0].length() > 1 && args[0].charAt(0) == '-') 
             testType = Character.toLowerCase(args[0].charAt(1));
        if(testType != 'a' && testType != 'l' && testType != 'o')
            testType = 'a';  
        return testType;
    }
}


