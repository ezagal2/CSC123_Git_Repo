import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerA_FloatB {
    public static void main(String[] args){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter integer: ");
            int a = scan.nextInt();
            System.out.print("Enter double: ");
            double b = scan.nextDouble();
            System.out.println(a/b);
        }catch (InputMismatchException e) {
            System.out.println("Error! enter an integer or double");
        }
    }
}
