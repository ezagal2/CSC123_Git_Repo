import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Lab7bQ1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("countries.txt"));
        HashMap<String, String> countries = new HashMap<>();

        while (scan.hasNextLine()) {
            String currentLine = scan.nextLine();
            String[] temp = currentLine.split(",");
            String country = temp[0];
            String population = temp[1];
            countries.put(country, population);
        }

        scan = new Scanner(System.in);
        System.out.print("Enter search string: ");
        String[] userInput = scan.nextLine().split(" ");
        String search = "";
        for (int i = 0; i < userInput.length; i++) {
            search += Character.toUpperCase(userInput[i].charAt(0)) + userInput[i].substring(1).toLowerCase() + " ";
        }

        if (countries.containsKey(search.trim())){
            System.out.println(search.trim());
            System.out.println("Population: " + countries.get(search.trim()));
        }
        else {
            System.out.println("country not found");
        }


    }
}