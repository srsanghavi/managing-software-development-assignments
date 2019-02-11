package sanghavis;

/**
 * The type Concrete observer 3.
 */
public class ConcreteObserver3 implements Observer {

    private String state = "";
    private ConcreteSubject observable;

    /**
     * Instantiates a new Concrete observer 3.
     *
     * @param observable the observable
     */
    ConcreteObserver3(ConcreteSubject observable){
        this.observable =observable;
        this.observable.attach(this);

    }

    /**
     * Update the state field when observer notify
     */
    @Override
    public void update() {
        state = observable.getState();
        changeState();
        System.out.println(state);
    }

    /**
     * change state field by the reverse of the observables' state
     */
    public void changeState() {
        StringBuilder stringBuilder = new StringBuilder(state);
        stringBuilder.reverse();
        state = stringBuilder.toString();
    }
}
