import java.io.File;
import java.util.Scanner;

public class Lab6bQ2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a directory path or name: ");
        String input = scan.nextLine();

        File directory = new File(input);
        if(!directory.exists()){
            System.out.println("Directory does not exist");
            System.exit(0);
        } else if (!directory.isDirectory()) {
            System.out.println("Direcory not found");
            System.exit(0);
        }

        File[] files = directory.listFiles();

        for (int i = 0; i < files.length; i++) {
            String fileName, fileType, ifReadable, ifWritable, ifExecutable;
            fileName = files[i].getName();
            fileType = files[i].isDirectory()? "Directory" : "File";
            ifReadable = files[i].canRead()? "Readable" : "Not-Readable";
            ifWritable = files[i].canWrite()? "Writable" : "Not-Writable";
            ifExecutable = files[i].canExecute()? "Executable" : "Not-Executable";
            System.out.printf("%d - %s (%s), %s, %s, %s\n", i+1, fileName, fileType, ifReadable, ifWritable, ifExecutable);
        }
        System.out.println("\nTotal files: " + files.length);
    }

}
