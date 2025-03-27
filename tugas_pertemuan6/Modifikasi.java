import java.io.*;
import java.util.*;

public class ListApp {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ItemList itemList = null;

            try {
                FileInputStream fin = new FileInputStream("list.out");
                ObjectInputStream oin = new ObjectInputStream(fin);
                itemList = (ItemList) oin.readObject();
                fin.close();
            } catch (FileNotFoundException | ClassNotFoundException | ClassCastException e) {
                itemList = new ItemList();
            }

            for (;;) {
                System.out.println("Menu :-");
                System.out.println("1.. Add item");
                System.out.println("2.. Delete item");
                System.out.println("3.. List items");
                System.out.println("4.. Save and quit");
                System.out.print("Choice : ");

                String response = reader.readLine();
                int choice = Integer.parseInt(response);

                switch (choice) {
                    case 1:
                        System.out.print("Enter item : ");
                        String item = reader.readLine();
                        itemList.addItem(item);
                        break;
                    case 2:
                        System.out.print("Enter item : ");
                        String deadItem = reader.readLine();
                        itemList.removeItem(deadItem);
                        break;
                    case 3:
                        for (String item : itemList.getItems()) {
                            System.out.println(item);
                        }
                        break;
                    case 4:
                        System.out.println("Saving list");
                        FileOutputStream fout = new FileOutputStream("list.out");
                        ObjectOutputStream oout = new ObjectOutputStream(fout);
                        oout.writeObject(itemList);
                        fout.close();
                        System.exit(0);
                }
            }
        } catch (IOException ioe) {
            System.err.println("I/O error");
        }
    }
}