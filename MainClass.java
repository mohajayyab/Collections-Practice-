package new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class MainClass {

    public static void main(String[] args) {
        Person alex=new Person("Alex",25);
        Person jane=new Person("Jane",22);
        Person tom=new Person("Tom",24);
        Person mary=new Person("Mary",6);

        System.out.println("- ArrayList"); //ArrayList: a resizable array
        ArrayList<Pesron> myList=new ArrayList<Person>();
        myList.add(alex);
        myList.add(jane);
        myList.add(jane);
        myList.add(tom);
        myList.add(1, mary);
        for (Person person : myList) {
            System.out.println(person.getName());

        }
        System.out.println("--- ArrayList after change");
        myList.set(0,new Person("Jim",60));
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i).getName());
        }
        //Arrays.asList creates a fix-sized list! It is not a real ArrayList.
        System.out.println("--- Arrays.asList: fix-sized list");
        List<Person> test=Arrays.asList(alex, jane, tom, mary);
        System.out.println(test.getClass()); // class java.util.Arrays$ArrayList
        System.out.println(myList.getClass()); // class java.util.ArrayList
        // This works: elements can be changed
        test.set(0,new Person("Jim",60));
        for (Person person : test) {
            System.out.println(person.getName());
        }
        //This does not work! The list is fix-sized.
        try {
            test.add(new Person("Eddie", 50));
        } catch (Exception e) {
            System.out.println("Cannot add element to fix-sized list.");
        }
        
        
        System.out.println("- PriorityQueue"); // PriorityQueue: an ordered queue (not FIFO)
        PriorityQueue<Person> queue=new PriorityQueue();

        //Comparable interface must be implemented
        //Adding a non-comparable element throws ClassCastException
        queue.add(jane);
        queue.add(alex);
        queue.add(mary);
        queue.add(jane);
        queue.add(tom);
        
        System.out.println("--- Peek: read head element");
        System.out.println(queue.peek());
        
        System.out.println("--- Change head element priority");
        queue.peek().setAge(60);
        System.out.println(queue.peek()); //Did not reorder
        queue.add(queue.poll()); //Remove and reinsert
        System.out.println(queue.peek()); //Now it is sorted.
        
        System.out.println("--- Poll: read and remove head element");
        Person p;
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.println("Name: "+p.getName()+", Age: "+p.getAge());
        }
        System.out.println("Queue size: "+queue.size());
        
        
        System.out.println("- LinkedList");
        //LinkedList: both a List and a Queue
        LinkedList<Person> lList=new LinkedList();
        lList.add(alex);
        lList.add(alex);
        lList.add(jane);
        lList.add(tom);
        //Elements can be added at a specific index like in a List
        lList.add(1, mary);
        for (Person person : lList) {
            System.out.println(person);
        }
        System.out.println("--- LinkedList as Queue:");
        //It can be used as a Queue (no priority here, just simple FIFO)
        System.out.println("Peek: "+lList.peek());
        while (!lList.isEmpty()) {
            p = lList.poll();
            System.out.println("Name: "+p.getName()+ ", Age: "+p.getAge());
        }
    }
    
}
