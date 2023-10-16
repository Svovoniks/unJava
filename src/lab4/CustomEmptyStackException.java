package lab4;

import java.io.*;
import java.util.EmptyStackException;

public class CustomEmptyStackException extends EmptyStackException {

    private static final String DEFAULT_ERROR_FILE = "errorFile";
    private String errorFile;

    public CustomEmptyStackException(){
        this(DEFAULT_ERROR_FILE);
    }

    public CustomEmptyStackException(String errorFile){
        this.errorFile = errorFile;

        try (PrintStream writer = new PrintStream(new FileOutputStream(errorFile, true))){
            this.printStackTrace(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Custom stack is empty";
    }
}
