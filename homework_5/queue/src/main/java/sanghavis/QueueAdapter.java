package sanghavis;

import java.util.ArrayList;

/**
 * The type Queue adapter.
 *
 * @param <T> the type parameter
 */
public class QueueAdapter<T> implements Queue<T> {
    private ArrayList<T> adaptee;

    /**
     * Instantiates a new Queue adapter.
     */
    public QueueAdapter(){
        adaptee = new ArrayList<>();
    }

    @Override
    public boolean add(T t) {
        adaptee.add(t);
        return false;
    }

    @Override
    public T remove() {
        if(adaptee.isEmpty()){
            return null;
        }
        return adaptee.remove(0);
    }

    @Override
    public T peek() {
       if(adaptee.isEmpty()){
           return  null;
       }
       return adaptee.get(adaptee.size()-1);
    }
}
