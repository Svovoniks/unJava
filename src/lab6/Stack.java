package lab6;

import java.util.Arrays;

public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element){
        if (data.length == size){
            data = Arrays.copyOf(data, data.length * 2);
        }

        data[size++] = element;
    }
    public T pop() {
        if (size == 0){
            return null;
        }

        return data[--size];
    }
    public T peek() {
        if (size == 0){
            return null;
        }
        return data[size-1];
    }
}
