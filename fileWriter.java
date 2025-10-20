import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class fileWriter {
    public static void main(String[] args) {

        String filePath = "file.txt";
        String content = """
                This is a sample text file.
                It contains multiple lines of text. 
                This file is created using FileWriter in Java.
                """;

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("File has been written successfully.");
        } 
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
