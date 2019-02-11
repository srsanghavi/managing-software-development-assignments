package sanghavis;


/**
 * The type Concrete observer 1.
 */
public class ConcreteObserver1 implements Observer {

    private String state = "";
    private ConcreteSubject observable;

    /**
     * Instantiates a new Concrete observer 1.
     *
     * @param observable the observable
     */
    ConcreteObserver1(ConcreteSubject observable){
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
     * change state by a string of the ASCII value of the obervables state
     */
    private void changeState() {
        String result="";
        boolean first = true;
        StringBuilder stringBuilder = new StringBuilder(result);
        for(int c : state.toCharArray()){
            if(!first) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(c);
            first = false;
        }
        state = stringBuilder.toString(); }
}
