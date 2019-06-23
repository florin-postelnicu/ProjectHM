


import java.io.*;
class Reciever {
    public static void main(String[] args) throws Exception {


      FileInputStream fis = new FileInputStream("comser.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ComSer cs2 = (ComSer)ois.readObject();
        System.out.println("ComSer is now with ComSer.i = "+cs2.i +"...ComSer.j = "+ cs2.j);

    }
}
