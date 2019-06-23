
import java.io.*;


class ComSer implements Serializable {

    int i = 10;
    int j = 20;
    private static final long serialVersionUID = 10L;
    ComSer() {
        System.out.println("Constructor for ComSer ");
    }
}
