import java.io.*;
import java.util.*;

public class ListApp {
    public static void main(String[] args) {
        try {
            // Construct a buffered reader for standard input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // The list of items
            Vector list = null;
            // Try and read the list back from the file
            try {
                FileInputStream fin = new FileInputStream("list.out");
                ObjectInputStream oin = new ObjectInputStream(fin);
                // Read the vector back from the list
                Object obj = oin.readObject();
                // Cast back to a vector
                list = (Vector) obj;
                fin.close();
            } catch (ClassCastException cce) {
                // Can't read it, create a blank one
                list = new Vector();
            } catch (ClassNotFoundException cnfe) {
                // Can't read it, create a blank one
                list = new Vector();
            } catch (FileNotFoundException fnfe) {
                // Create a blank vector
                list = new Vector();
            }
            // Repeat indefinitely
            for (;;) {
                // Now, display menu
                System.out.println("Menu :-");
                System.out.println("1.. Add item");
                System.out.println("2.. Delete item");
                System.out.println("3.. List items");
                System.out.println("4.. Save and quit");
                System.out.print("Choice : ");
                // Read choice
                String response = reader.readLine();
                // Convert to an int
                int choice = Integer.parseInt(response);
                switch (choice) {
                    case 1:
                        // Add the item to list
                        System.out.print("Enter item : ");
                        String item = reader.readLine();
                        list.addElement(item);
                        break;
                    case 2:
                        // Delete the item from list
                        System.out.print("Enter item : ");
                        String deadItem = reader.readLine();
                        list.removeElement(deadItem);
                        break;
                    case 3:
                        // List the elements of the list
                        for (Enumeration e = list.elements(); e.hasMoreElements();) {
                            System.out.println(e.nextElement());
                        }
                        break;
                    case 4:
                        // Save list and terminate
                        System.out.println("Saving list");
                        FileOutputStream fout = new FileOutputStream("list.out");
                        // Construct an object output stream
                        ObjectOutputStream oout = new ObjectOutputStream(fout);
                        // Write the object to the stream
                        oout.writeObject(list);
                        fout.close();
                        System.exit(0);
                }
            }
        } catch (IOException ioe) {
            System.err.println("I/O error");
        }
    }
}