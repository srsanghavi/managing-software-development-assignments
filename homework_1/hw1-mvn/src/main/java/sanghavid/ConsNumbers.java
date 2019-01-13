package sanghavid;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to implement the methods
 * for obtaining consecutive numbers between two numbers.
 *
 * Here the numbers are integer.
 *
 * @author shashwat sanghavi
 */

public class ConsNumbers implements Sequence{

    /**
     * List to hold numbers between two numbers
     */
    List<Integer> numList;

    /**
     * Default contructor to initialize the list
     */
    ConsNumbers(){
        this.numList = new ArrayList<Integer>();
    }

    /**
     * This method takes two numbers as an input
     * @return a list of numbers between two input numbers
     */
    public List<Integer> getSequence(int num1,int num2){
        /**
         * Swap numbers if num1>num2
         */
        if(num1>num2){
            num1 = num1+num2;
            num2 = num1-num2;
            num1 = num1-num2;
        }
        for (int i=num1+1; i<num2; i++){
            this.numList.add(i);
        }
        return this.numList;
    }
}

