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
    private int _size;


    public HashTable(){
        table = new LinkedList[42];
        _size = 0;
    }
    public void put(K key, V value) {
        int index = hash(key);

        if (index > table.length - 1){
            LinkedList<Entry<K, V>>[] newTable = new LinkedList[
                    Math.max(table.length * 2, index + 1)];
            System.arraycopy(table, 0, newTable, 0, table.length);
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
        _size++;
    }

    public V get(K key){
        int index = hash(key);

        if (index > table.length - 1 || table[index] == null){
            return null;
        }

        for (Entry<K, V> entry : table[index]){

            if (entry.key.equals(key)){
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
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                _size--;
                return;
            }
        }

    }

    public int size() {
        return _size;
    }

    public boolean isEmpty(){
        return _size == 0;
    }
}
