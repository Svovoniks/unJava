package lab4;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileFail {
    public static void main(String[] args) {
        fail("je", "ja");
        fail("E:\\file", "E:\\newfile");
    }

    private static void fail(String name, String dest){
        try (FileInputStream inputStream = new FileInputStream(name);
             FileOutputStream outputStream = new FileOutputStream(dest)) {

            outputStream.write(inputStream.readAllBytes());


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
