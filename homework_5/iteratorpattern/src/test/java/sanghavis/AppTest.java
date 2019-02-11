package sanghavis;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    // check constructor for bitvector
    @Test
    public void shouldCreateAnEmptyBitVector(){
        BitVector bitVector = new BitVector();
        assertTrue(bitVector.size()==0);
    }

    //check set

    @Test
    public void bitVectorShouldHoldNumbers(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        bitVector.set(4);
        bitVector.set(7);
        bitVector.set(31);
        Iterator<Integer> bIt = bitVector.iterator();
        int resNum = bIt.nextElement();
        assertTrue(Integer.toBinaryString(resNum).equals("10000000000000000000000010010011")&& !bIt.hasAnotherElement());
    }

    @Test
    public void bitVectorShouldAllowLargerNumbers(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        bitVector.set(4);
        bitVector.set(7);
        bitVector.set(31);
        bitVector.set(65);
        Iterator<Integer> bIt = bitVector.iterator();
        int resNum;
        bIt.nextElement();
        bIt.nextElement();
        resNum = bIt.nextElement();
        assertTrue(Integer.toBinaryString(resNum).equals("10")&& !bIt.hasAnotherElement());
    }

    //check get()

    @Test
    public void shouldGetSetBit(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        assertTrue(bitVector.get(1));
    }

    @Test
    public void shouldGetUnSetBit(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        assertFalse(bitVector.get(11));
    }

    @Test
    public void shouldGetUnsetBitVeryLargeNumber(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        assertFalse(bitVector.get(11111));
    }

    @Test
    public void shouldGetUnsetBitLargeNumber(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        assertFalse(bitVector.get(33));
    }


    @Test
    public void shouldGetLargeSetBit(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1111);
        bitVector.set(11111);
        bitVector.set(11111111);
        bitVector.set(1111111111);

        assertTrue(bitVector.get(0));
        assertTrue(bitVector.get(1111));
        assertTrue(bitVector.get(11111));
        assertTrue(bitVector.get(11111111));
        assertTrue(bitVector.get(1111111111));

        assertFalse(bitVector.get(1100));
        assertFalse(bitVector.get(1112));
        assertFalse(bitVector.get(1));
        assertFalse(bitVector.get(22222));
    }


    //check clear
    @Test
    public void shouldClearABit(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1111);
        bitVector.set(11111);
        bitVector.clear(1111);

        assertTrue(bitVector.get(0));
        assertFalse(bitVector.get(1111));
        assertTrue(bitVector.get(11111));
    }

    @Test
    public void shouldClearALargeUnsetBit(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.clear(1111);

        assertTrue(bitVector.get(0));
        assertFalse(bitVector.get(1111));
    }

    @Test
    public void shouldClearAnUnsetBit(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.clear(1);
        assertTrue(bitVector.get(0));
        assertFalse(bitVector.get(1));
    }


    // check copy
    @Test
    public void copyLargerBitVectorToSmall(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        bitVector.set(4);
        BitVector bitVector1 = new BitVector();
        bitVector1.set(65);
        bitVector.copy(bitVector1);

        int[] res = new int[3];
        res[0] = 19;
        res[1] = 0;
        res[2] = 2;

        boolean ans = true;
        Iterator<Integer> bIt = bitVector.iterator();
        int i = 0;
        while (bIt.hasAnotherElement()){
            int next = bIt.nextElement();
            ans = ans && res[i]==next;
            i++;
        }
        assertTrue(ans && !bIt.hasAnotherElement());
    }

    @Test
    public void copySmallerBitVectorToLarge(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        bitVector.set(4);
        BitVector bitVector1 = new BitVector();
        bitVector1.set(65);
        bitVector1.copy(bitVector);

        int[] res = new int[3];
        res[0] = 19;
        res[1] = 0;
        res[2] = 2;

        boolean ans = true;
        Iterator<Integer> bIt = bitVector1.iterator();
        int i = 0;
        while (bIt.hasAnotherElement()){
            int next = bIt.nextElement();
            ans = ans && res[i]==next;
            i++;
        }
        assertTrue(ans && !bIt.hasAnotherElement());
    }


    // check size()
    @Test
    public void checkSizeForEmptyBitVector(){
        BitVector bitVector = new BitVector();
        assertEquals(0,bitVector.size());
    }

    @Test
    public void checkSizeForsmallNumbersBitVector(){
        BitVector bitVector = new BitVector();
        bitVector.set(1);
        bitVector.set(32);
        bitVector.set(15);
        assertEquals(3,bitVector.size());
    }

    @Test
    public void checkSizeForsmallAndLargeNumbersBitVector(){
        BitVector bitVector = new BitVector();
        bitVector.set(1);
        bitVector.set(32);
        bitVector.set(15);
        bitVector.set(14321);
        bitVector.set(32242342);
        assertEquals(5,bitVector.size());
    }

    //check iterator
    @Test
    public void checkIterator(){
        BitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        bitVector.set(4);
        bitVector.set(66);

        int[] res = new int[3];
        res[0] = 19;
        res[1] = 0;
        res[2] = 4;

        boolean ans = true;
        Iterator<Integer> bIt = bitVector.iterator();
        int i = 0;
        while (bIt.hasAnotherElement()){
            int next = bIt.nextElement();
            ans = ans && res[i]==next;
            i++;
        }
        assertTrue(ans && !bIt.hasAnotherElement());
    }
}
