import java.io.Serializable;
import java.util.Vector;

public class ItemList implements Serializable {
    private Vector<String> items;

    public ItemList() {
        items = new Vector<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public Vector<String> getItems() {
        return items;
    }
}

// Penjelasan:

//Kelas ItemList mengimplementasikan antarmuka Serializable, yang memungkinkan objek dari kelas ini untuk diserialisasi.
//Kelas ini memiliki atribut items bertipe Vector<String> untuk menyimpan daftar item.
//Kelas ini memiliki metode addItem, removeItem, dan getItems untuk memanipulasi daftar.