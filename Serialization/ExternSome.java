

import java.io.*;

class ExternalizableDemo implements Externalizable
{
    String s;
    int i;
    int j;
    public ExternalizableDemo()
    {
        System.out.println("Public Cons no Args");
    }
    public ExternalizableDemo (String s,int i, int j)
    {
        this.s = s;
        this.i = i;
        this.j = j;


    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(s);
        out.writeObject(i);
    }
    public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException
    {
        s =(String)oi.readObject();
        i = (int)oi.readObject();

    }

}

class TestExternDem {

    public static void main(String[] args) throws Exception{


        ExternalizableDemo d1 = new ExternalizableDemo("kastelka", 10, 20);
        FileOutputStream fou = new FileOutputStream("externdemo.ser");
        ObjectOutputStream ous = new ObjectOutputStream(fou);
        ous.writeObject(d1);

        FileInputStream fis = new FileInputStream("externdemo.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ExternalizableDemo d2 =(ExternalizableDemo)ois.readObject();
        System.out.println(d2.s + "....." + d2.i + "...."+ d2.j);
    }

}