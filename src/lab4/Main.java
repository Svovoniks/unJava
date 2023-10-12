package lab4;

public class Main {
    public static void main(String[] args) {
        CustomStack<String> stack  = new CustomStack<>();

        try {
            stack.pop();
        }
        catch (CustomEmptyStackException e){
            System.out.println(e);
        }

        stack.push("hey");

        try {
            System.out.println(stack.pop());
        } catch (CustomEmptyStackException e) {
            throw new RuntimeException(e);
        }
    }
}
