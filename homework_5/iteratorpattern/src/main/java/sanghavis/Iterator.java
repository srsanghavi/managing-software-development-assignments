package sanghavis;

/**
 * A generic iterator
 *
 * @param <T> the type parameter
 */
public interface Iterator<T> {
    /**
     * Check if there are more elements
     *
     * @return the boolean
     */
    boolean hasAnotherElement();

    /**
     * Return the next element
     *
     * @return the t
     */
    T nextElement();
}
