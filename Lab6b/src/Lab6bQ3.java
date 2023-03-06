import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab6bQ3 {
    public static void main (String[] args) throws FileNotFoundException, TooManyNumbersException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a text File: ");
        File file = new File(scan.nextLine());
        if (!file.exists()){
            System.out.println("File does not exist");
            System.exit(0);
        }
        scan = new Scanner(file);
        int count = 0;
        while (scan.hasNext()) {
            String line = scan.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isDigit(c)) {
                    count++;
                    if (count > 10) {
                        throw new TooManyNumbersException();
                    }
                }
            }
        }
        System.out.println("Numerical characters: " + count);
    }
}
class TooManyNumbersException extends Exception{
    public TooManyNumbersException(){
        super("Number of numerical characters exceeded limit!");
    }
}