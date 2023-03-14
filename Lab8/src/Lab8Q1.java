import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Lab8Q1 {
    public static void main(String[] args) throws IOException {

        Stack<String> lines = new Stack<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter source file: ");
        String source = scan.nextLine();
        File sourceFile = new File(source);
        if (!sourceFile.exists()){
            System.out.println("Source File Does Not Exist");
            System.exit(0);
        }


        System.out.print("Enter target file: ");
        String target = scan.nextLine();
        File targetFile = new File(target);
        if (targetFile.exists()){
            System.out.println("Target File Already Exist");
            System.exit(0);
        }


        scan = new Scanner(sourceFile);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.push(line);
        }
        scan.close();
        String outputString = "";
        FileWriter fileWriter = new FileWriter(targetFile);

        while (!lines.isEmpty()){
            outputString += lines.pop() + "\n";
        }
        fileWriter.write(outputString);
        fileWriter.close();

    }
}
