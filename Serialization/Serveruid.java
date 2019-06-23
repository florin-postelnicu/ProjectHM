
/*
A thread-safe, mutable sequence of characters.
 * A string buffer is like a {@link String}, but can be modified. At any
 * point in time it contains some particular sequence of characters, but
 * the length and content of the sequence can be changed through certain
 * method calls.
 * <p>
 * String buffers are safe for use by multiple threads. The methods
 * are synchronized where necessary so that all the operations on any
 * particular instance behave as if they occur in some serial order
 * that is consistent with the order of the method calls made by each of
 * the individual threads involved.
 * <p>
 * The principal operations on a {@code StringBuffer} are the
 * {@code append} and {@code insert} methods, which are
 * overloaded so as to accept data of any type. Each effectively
 * converts a given datum to a string and then appends or inserts the
 * characters of that string to the string buffer. The
 * {@code append} method always adds these characters at the end
 * of the buffer; the {@code insert} method adds the characters at
 * a specified point.
 * <p>
 * For example, if {@code z} refers to a string buffer object
 * whose current contents are {@code "start"}, then
 * the method call {@code z.append("le")} would cause the string
 * buffer to contain {@code "startle"}, whereas
 * {@code z.insert(4, "le")} would alter the string buffer to
 * contain {@code "starlet"}.
 * <p>
 * In general, if sb refers to an instance of a {@code StringBuffer},
 * then {@code sb.append(x)} has the same effect as
 * {@code sb.insert(sb.length(), x)}.
 * <p>
 * Whenever an operation occurs involving a source sequence (such as
 * appending or inserting from a source sequence), this class synchronizes
 * only on the string buffer performing the operation, not on the source.
 * Note that while {@code StringBuffer} is designed to be safe to use
 * concurrently from multiple threads, if the constructor or the
 * {@code append} or {@code insert} operation is passed a source sequence
 * that is shared across threads, the calling code must ensure
 * that the operation has a consistent and unchanging view of the source
 * sequence for the duration of the operation.
 * This could be satisfied by the caller holding a lock during the
 * operation's call, by using an immutable source sequence, or by not
 * sharing the source sequence across threads.
 * <p>
 * Every string buffer has a capacity. As long as the length of the
 * character sequence contained in the string buffer does not exceed
 * the capacity, it is not necessary to allocate a new internal
 * buffer array. If the internal buffer overflows, it is
 * automatically made larger.
 * <p>
 * Unless otherwise noted, passing a {@code null} argument to a constructor
 * or method in this class will cause a {@link NullPointerException} to be
 * thrown.
 * <p>
 * As of  release JDK 5, this class has been supplemented with an equivalent
 * class designed for use by a single thread, {@link StringBuilder}.  The
 * {@code StringBuilder} class should generally be used in preference to
 * this one, as it supports all of the same operations but it is faster, as
 * it performs no synchronization.
 *
 * @author      Arthur van Hoff
 * @see     java.lang.StringBuilder
 * @see     java.lang.String
 * @since   JDK1.0
 */

import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private byte age;
    private String address;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public byte getAge() {
        return age;
    }
    public void setAge(byte age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String whoIsThis() {
        StringBuffer employee = new StringBuffer();
        employee.append(getName()).append(" is ").append(getAge()).append(" years old and lives at ")
                .append(getAddress());
        return employee.toString();
    }
}

 class Writer {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee();
        employee.setName("Ashintha");
        employee.setAge((byte) 30);
        employee.setAddress("Galle");
        FileOutputStream fout = new FileOutputStream("serveruid.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(employee);
        oos.close();
        System.out.println("Process complete");
    }
}

class Reader {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Employee employee = new Employee();
        FileInputStream fin = new FileInputStream("serveruid.ser");
        ObjectInputStream ois = new ObjectInputStream(fin);
        employee = (Employee) ois.readObject();
        ois.close();
        System.out.println(employee.whoIsThis());
    }
}
