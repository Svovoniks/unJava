package lab3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import static java.util.Objects.hash;


public class HashTable <K, V> {
    public static class Entry<K, V>{
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K key;
        public V value;
    }


    private LinkedList<Entry<K, V>>[] table;

    public HashTable(){
        table = new LinkedList[42];
    }
    public void put(K key, V value) {
        int index = hash(key);

        if (index > table.length - 1){
            LinkedList<Entry<K, V>>[] newTable = new LinkedList[
                    Math.max(table.length * 2, index + 1)];
            System.arraycopy(table, 0, newTable, 0, newTable.length);
            table = newTable;
        }

        if (table[index] == null){
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]){
            if (entry.key == key){
                entry.value = value;
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
    }

    public V get(K key){
        int index = hash(key);

        if (index > table.length - 1 || table[index] == null){
            return null;
        }

        for (Entry<K, V> entry : table[index]){
            if (entry.key == key){
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key){
        int index = hash(key);

        if (index > table.length - 1 || table[index] == null){
            return;
        }

        for (Entry<K, V> entry : table[index]){
            if (entry.key == key) {
                table[index].remove(entry);
                return;
            }
        }

    }
}
