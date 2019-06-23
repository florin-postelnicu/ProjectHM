/*
Instance Control Flow in Parent-Child Relationship
Whenever we are creating Child class object, the following sequence of events will be performed automatically
as a part of instance control flow.

1) Identification of instance members from parent to child. (instance variables, methods,
and blocks are considered instance members)

2) The execution of instance variable assignments and instance blocks only in parent class.

3) Implementation of parent class constructor.

4) Execution of instance variable assignments and instance blocks only in child class.

5) Implementation of child class constructor.




After running each of the main(parent first, and then child) that's the outcome:

0
First Instance Block of Parent
Parent Constructor
0
First Instance Block of Child
Second Instance Block of Child
Child Constructor
Child class Main method is executing

 */

class Parent
{
    // initializing parent class integer pvar1 to be 5
    int pvar1 = 5;

    // first instance block of Parent
    {
        // calling pmethod
        pmethod();
        System.out.println("First Instance Block of Parent");
    }

    // Parent constructor
    Parent()
    {
        System.out.println("Parent Constructor");
    }

    // static main method of Parent
    public static void main(String[] args)
    {
        // creating object of Parent
        Parent p = new Parent();
        System.out.println("Parent class Main method is executing");
    }

    // pmethod
    public void pmethod()
    {
        // displaying value of var2
        System.out.println(pvar2);
    }

    // initializing parent class integer pvar2 to be 10
    int pvar2 = 10;
}


//Child class
class Child extends Parent
{
    // initializing child class integer cvar1 to be 50
    int cvar1 = 50;

    // first instance block of Child
    {
        // calling cmethod() from first instance block
        cmethod();
        System.out.println("First Instance Block of Child");
    }

    // Child constructor
    Child()
    {
        System.out.println("Child Constructor");
    }

    // static main method of Child class
    public static void main(String[] args)
    {
        // creating object of Child
        Child c = new Child();
        System.out.println("Child class Main method is executing");
    }

    // cmethod
    public void cmethod()
    {
        // displaying value of cvar2
        System.out.println(cvar2);
    }

    // second instance block of Child
    {
        System.out.println("Second Instance Block of Child");
    }

    // initializing child class integer cvar2 to be 100
    int cvar2 = 100;
}
