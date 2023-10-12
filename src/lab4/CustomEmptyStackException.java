package lab4;

public class CustomEmptyStackException extends Exception {

    @Override
    public String toString() {
        return "Custom stack is empty";
    }
}
