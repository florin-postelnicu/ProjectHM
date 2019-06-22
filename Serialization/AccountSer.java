package com.example.annimation;
/*
It seems that private vars can not be Serializable
since they can not be used outside of their class
 */

import java.io.*;

class AccountSer implements Serializable {
    String user = " Kastelka";
    private String show = "show";
    transient  String pwrd = "FionaLira";
    transient int pin = 12345;
    // Methods for customizing serialization

    private void writeObject( ObjectOutputStream os) throws Exception{
        // Read the default objects
        os.defaultWriteObject();

        // Encrypt the hiden pwrd
        String epwrd = "123" + pwrd;
        int epin = 3*pin;
        // Write the encrypted epwrd
        os.writeObject(epwrd);
        os.writeObject(epin);

    }
    private void readObject( ObjectInputStream is) throws Exception {
        //Read the default objects
        is.defaultReadObject();
        //Read the encrypted epwrd
        String epwrd = (String)is.readObject();
        //Decrypt the encrypted epwrd
        pwrd = epwrd.substring(3);
        int epin = (int)is.readObject();
        pin = epin/3;




    }
}


class AccDemoSer {
    public static void main(String[] args) throws Exception {


        AccountSer ac1 = new AccountSer();
        System.out.println("Account User Name : " + ac1.user + " Account Password pwrd : " + ac1.pwrd + " pin : " + ac1.pin);
//        System.out.println(ac1.pwrd + ac1.pwrd.length());
        FileOutputStream fos = new FileOutputStream("accser.ser");
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(ac1);



        FileInputStream fis = new FileInputStream("accser.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        AccountSer ac2 = (AccountSer)ois.readObject();
        System.out.println("Account User Name : " + ac2.user + " Account Password pwrd : " + ac2.pwrd + " pin :" + ac2.pin);

    }
}