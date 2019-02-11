package sanghavis;

/**
 * The interface Subject.
 */
public interface Subject {
    /**
     * Attach.
     *
     * @param observer the observer
     */
    void attach(Observer observer);

    /**
     * Detach.
     *
     * @param observer the observer
     */
    void detach(Observer observer);

    /**
     * Notify observers.
     */
    void notifyObservers();
}
