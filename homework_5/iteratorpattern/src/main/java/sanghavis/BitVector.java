package sanghavis;


/**
 * The type Bit vector.
 */
public class BitVector implements IBitVector {

    private int[] array;
    private int size;

    /**
     * Instantiates a new Bit vector.
     */
    public BitVector(){
        size = 1;
        array = new int[size];
    }

    @Override
    public boolean get(int i) {
        int arrayIndex = i/32;
        int bitIndex = i%32;
        if(arrayIndex>=size){
            return false;
        }
        int number = array[arrayIndex];
        return (number >> (bitIndex))==1;
    }

    @Override
    public void set(int i) {
        int arrayIndex = i/32;
        int bitIndex = i%32;
        if(arrayIndex<size) {
            int number = 0;
            number |= 1 << bitIndex;
            array[arrayIndex] = array[arrayIndex] | number;
        }else {
            int number = 0;
            number |= 1 << bitIndex;
            int[] temp = new int[arrayIndex+1];
            for(int k=0;k<size;k++){
                temp[k]=array[k];
            }
            temp[arrayIndex]=number;
            array = temp;
            size = array.length;
        }
    }

    @Override
    public void clear(int i) {
        int arrayIndex = i/32;
        int bitIndex = i%32;
        if(arrayIndex<size) {
            int number = array[arrayIndex];
            array[arrayIndex] = number & ~(1 << bitIndex);
        }
    }

    @Override
    public void copy(BitVector b) {
        if(b.arraySize()<this.arraySize()){
            Iterator<Integer> bIterator  = b.iterator();
            int i = 0;
            while (bIterator.hasAnotherElement()){
                int bElement = bIterator.nextElement();
                array[i] |= bElement;
                i++;
            }
        }else {
            int[] temp = new int[b.arraySize()];
            Iterator<Integer> bIterator  = b.iterator();
            int i = 0;
            while (bIterator.hasAnotherElement()){
                int bElement = bIterator.nextElement();
                temp[i] = i < arraySize() ? array[i] | bElement : bElement;
                i++;
            }
            array = temp;
        }
    }

    /**
     * Count set bits int.
     *
     * @param n the n
     * @return the int
     */
    public static int countBits(int n) {
        if (n == 0)
            return 0;
        else
            return (n & 1) + countBits(n >> 1);
    }

    /**
     *
     * @return number of integers in the bitvector
     */
    private int arraySize(){
        return this.array.length;
    }

    @Override
    public int size() {
        int count = 0;
        for(int i=0;i<size;i++){
            count += countBits(array[i]);
        }
        return count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IBitVectorIterator(this);
    }


    private class IBitVectorIterator implements Iterator<Integer>{
        private int[] integers;
        private int cnt;

        /**
         * Instantiates a new Bit vector iterator.
         *
         * @param iBitVector the bit vector
         */
        IBitVectorIterator(IBitVector iBitVector){
            integers = ((BitVector)iBitVector).array.clone();
            cnt = 0;
        }
        @Override
        public boolean hasAnotherElement() {
            return cnt < integers.length;
        }

        @Override
        public Integer nextElement() {
            int res = integers[cnt];
            cnt++;
            return res;
        }
    }
}
