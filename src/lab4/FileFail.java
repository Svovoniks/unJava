package lab4;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileFail {
    public static void main(String[] args) {
        fail("je", "ja");
        fail("errorFile", "newErrorFile");
    }

    private static void fail(String name, String dest){
        SecurityManager manager = new SecurityManager();
        try (FileInputStream inputStream = new FileInputStream(name);
             FileOutputStream outputStream = new FileOutputStream(dest)) {

            manager.checkRead(name);
            manager.checkWrite(dest);

            inputStream.transferTo(outputStream);
        }
        catch (SecurityException e){
            System.out.println("Access denied");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
