package sanghavis;

/**
 * The type Concrete observer 2.
 */
public class ConcreteObserver2 implements Observer {

    /**
     * hold the value of state that
     */
    private String state = "";
    private ConcreteSubject observable;
    /**
     * Instantiates a new Concrete observer 2.
     *
     * @param observable the observable
     */
    ConcreteObserver2(ConcreteSubject observable){
        this.observable = observable;
        this.observable.attach(this); }


    /**
     * Update the state field when observer notify
     */
    @Override
    public void update() {
        state = observable.getState();
        this.changeState();
        System.out.println(state); }


    /**
     * change state by a string of the ASCII value (HEX) of the obervables state
     */
    private void changeState() {
        String result="";
        boolean first = true;
        StringBuilder stringBuilder = new StringBuilder(result);
        for(int c : state.toCharArray()){
            if(!first) {
                stringBuilder.append(" "); }

            stringBuilder.append(Integer.toHexString(c));
            first = false;
        }
        state = stringBuilder.toString();
    }
}
