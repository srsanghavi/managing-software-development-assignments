package sanghavis;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Concrete subject.
 */
public class ConcreteSubject implements Subject {
    private String state;
    private List<Observer> observers = new ArrayList<>();

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
        this.notifyObservers();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
}
