import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab7aQ2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter search String: ");
        String userInput = scan.nextLine().trim();

        scan = new Scanner(new File("countries.txt"));

        System.out.printf("The countries matching your input “%s” are:\n\n", userInput);
        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] currentLine = line.split(",");
            String country = currentLine[0];
            String population = currentLine[1];
            if (country.toLowerCase().contains(userInput.toLowerCase())){
                System.out.printf("%-33s - Population: %s\n", country, population);
            }
        }

    }
}
