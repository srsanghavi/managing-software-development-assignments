package sanghavid;

import java.util.List;
import java.util.Scanner;

/**
 * This class reads two numbers from the console and
 * returns a list of numbers between them
 *
 * @author shashwat sanghavi
 */
public class App 
{
    public static void main( String[] args ){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number 1");
        int num1 = scan.nextInt();
        System.out.println("Enter number 2");
        int num2 = scan.nextInt();
        ConsNumbers CN = new ConsNumbers();
        List<Integer> resList = CN.getSequence(num1,num2);
        System.out.println("Result"+resList);
    }
}
