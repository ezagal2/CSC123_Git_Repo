import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab7aQ1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the source file name: ");
        String sourceFileName = scan.nextLine();
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()){
            System.out.println("Error! file does not exist");
            System.exit(0);
        }

        System.out.print("Enter the target file name: ");
        String targetFileName = scan.nextLine();
        File targetFile = new File(targetFileName);
        if (!targetFile.createNewFile()){
            System.out.println("Error! file already exists");
            System.exit(0);
        }

        scan = new Scanner(sourceFile);
        FileWriter fileWriter = new FileWriter(targetFileName);
        while(scan.hasNext()){
            fileWriter.write(scan.nextLine());
            fileWriter.write("\n");
        }
        fileWriter.close();

    }
}