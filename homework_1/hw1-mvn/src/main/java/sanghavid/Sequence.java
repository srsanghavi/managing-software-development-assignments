package sanghavid;

import java.util.List;

/**
 * A Sequence is an object of any class that
 * implements Sequence
 * @author Shashwat Sanghavi
 *
 */
public interface Sequence {

    /**
     *
     * @param number1 - Begin number
     * @param number2 - End Number
     * @return List of Integers between
     *         number1 and number2
     */
    List<Integer> getSequence(int number1,int number2);

}