package lab4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class CustomStack<T> {
    private final Stack<T> stack;
    public CustomStack(){
        stack = new Stack<>();
    }

    public T pop() throws CustomEmptyStackException {
        if (stack.empty()){
            throw new CustomEmptyStackException();
        }

        return stack.pop();
    }

    public void push(T element){
        stack.push(element);
    }
}
