package sanghavis;


/**
 * A bitvector.
 */
public interface IBitVector {

    /**
     * Determine if the bit at position i is set.
     *
     * @param i the
     * @return the boolean
     */
    public boolean get(int i);

    /**
     * Set the bit at position i.
     *
     * @param i the
     */
    public void set(int i);

    /**
     * Clear the bit at position i.
     *
     * @param i the
     */
    public void clear(int i);

    /**
     * Set the bits in the argument BitVector b.
     *
     * @param b the b
     */
    public void copy(BitVector b);

    /**
     * Determine the number of non-zero bits in the BitVector.
     *
     * @return the int
     */
    public int size();

    /**
     * Iterator over the Integer values represented by this BitVector.
     *
     * @return the iterator
     */
    public Iterator<Integer> iterator();

}