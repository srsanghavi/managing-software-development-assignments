package sanghavid;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for Sequence.
 *
 * @author shashwat sanghavi
 */
public class SequenceTest {

    private  int num1,num2,num3;
    private List<Integer> testOutList;

    /**
     * Default constructor which initializes
     * values for input and output.
     */
    public SequenceTest(){
        this.num1 = 1;
        this.num2 = 2;
        this.num3 = 5;
        this.testOutList = new ArrayList<Integer>();
        this.testOutList.add(3);
        this.testOutList.add(4);
    }

    /**
     * Test case to check number list to be empty between two
     * consecutive integers.
     */
    @Test
    public void isSequenceListNull() {
        ConsNumbers CN = new ConsNumbers();
        List<Integer> tempList = CN.getSequence(num1,num2);
        assertEquals(tempList,new ArrayList<Integer>());
    }

    /**
     * Test case to check number list to be empty between two
     * same integers.
     */
    @Test
    public void isSequenceListNullBetweenSame(){
        ConsNumbers CN = new ConsNumbers();
        List<Integer> tempList = CN.getSequence(num2,num2);
        assertEquals(tempList,new ArrayList<Integer>());
    }

    /**
     * Test case to check number list of integers between two
     * consicutive integers.
     */
    @Test
    public void CheckSequence(){
        ConsNumbers CN = new ConsNumbers();
        List<Integer> tempList = CN.getSequence(num2,num3);
        assertEquals(tempList,this.testOutList);
    }

    /**
     * Test case to check number list of integers between two
     * consicutive integers in descending order.
     */
    @Test
    public void CheckSequenceDecending(){
        ConsNumbers CN = new ConsNumbers();
        List<Integer> tempList = CN.getSequence(num3,num2);
        assertEquals(tempList,this.testOutList);
    }
}