import java.io.File;
import java.io.IOException;

public class Lab6bQ1 {

    public static void main(String[] args) {

        File directoriesToMake = new File("lab6b/challenge1/subfolder");

        directoriesToMake.mkdirs();

        File file = new File(directoriesToMake, "test.txt");

        try {
            file.createNewFile();
            file.setReadable(true);
            file.setWritable(false);
            file.setExecutable(false);
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
        }
    }
}
