
import java.io.*;


class SenderSer {


    public static void main(String[] args) throws Exception{
        ComSer cs = new ComSer();

        cs.j = 150;
        System.out.println("ComSer is now with ComSer.i = "+cs.i +"...ComSer.j = "+ cs.j);
        FileOutputStream fos = new FileOutputStream("comser.ser");
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(cs);
        ous.close();

    }
}
