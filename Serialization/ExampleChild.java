

/*
I have introduce a constructor for the ParentNotSer and although
the constructor of parent class is executed before anything in the child class
, I didn't get an error suggested by "theory" : Run Time Exception
InvalidCalssException

Rule says : Every Non Serializable class should not have argument constructor,
 unless  default constructor of  Compiler are explicitly provided by the programmer

 https://youtu.be/Y5KXGLbCzbc

 Running this program we get :

R1)    This is a constructor in ParentNotSer
R2)    This is a constructor for ChildSer
R3)    baby.i : 888...baby.j : 999
R4)    This is a constructor in ParentNotSer
R5)    babymare.i : 10...babymare.j : 999

Process finished with exit code 0

The lines R1 and R2 are as a result of generating the instance baby  for ChildSer .
Since ChildSer is a child, first it is executed thr constructor of the Parent, and the
the constructor of the Child.

R3) is the new instance baby

R4) After deserialization, the Parent class which is not Serializable would have its constructor executed.
The Instance Control Flow would assign a default value to the variable inherited from the parent class i = 0;
then, based on how the Instance Control Flow works with JVM
the parent instance member that was NOT Serialized would be assigned
the Original Value in the Parent class.
Hence:
R5


If modifying the program such that the Parent constructor is :

  ParentNotSer(int i){

        System.out.println("This is a constructor in ParentNotSer");

    }
    therefore, depending on var i,
    and , as a consequence the Child superimposes
    super(10) the value for i
    then the running is :

    This is a constructor in ParentNotSer
This is a constructor for ChildSer
baby.i : 888...baby.j : 999
Serialization Started
Deserialization started now
Exception in thread "main" java.io.InvalidClassException: ChildSer; no valid constructor
	at java.io.ObjectStreamClass$ExceptionInfo.newInvalidClassException(ObjectStreamClass.java:169)
	at java.io.ObjectStreamClass.checkDeserialize(ObjectStreamClass.java:874)
	at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2043)
	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1573)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:431)
	at ControlFlowDemo.main(ExampleChild.java:74)

Process finished with exit code 1


Conclusion:
The Parent class if not Serializable, than it shouldn't contain
an argument Constructor.
for example
ParentNotSr( int i){
...}
Here the argument is the variable i.

 */
import java.io.*;

class ParentNotSer {

    int i = 10;
//    ParentNotSer(int i){
//
//        System.out.println("This is a constructor in ParentNotSer");
//
//    }
    ParentNotSer (){
        System.out.println("This is a constructor in ParentNotSer");

    }
}

class ChildSer extends ParentNotSer implements Serializable {
    int j = 100;

    ChildSer() {
//        super(10); // used only with the special constructor
        System.out.println("This is a constructor for ChildSer");
    }
}
class ControlFlowDemo {

    public static void main(String[] args) throws Exception {
        ChildSer baby = new ChildSer();
        baby.i = 888;
        baby.j = 999;

        System.out.println("baby.i : " + baby.i +"...baby.j : "+ baby.j  );
        System.out.println("Serialization Started");
        FileOutputStream fos = new FileOutputStream("parentchild.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(baby);

        System.out.println("Deserialization started now ");
        FileInputStream fis = new FileInputStream("parentchild.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ChildSer babymare = (ChildSer)ois.readObject();
        System.out.println("babymare.i : " + babymare.i +"...babymare.j : "+ babymare.j);

    }
}
