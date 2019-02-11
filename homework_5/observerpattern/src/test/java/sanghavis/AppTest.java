package sanghavis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sanghavis.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Unit test for Observer pattern.
 */
public class AppTest 
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldUpdateAllObservers(){
        ConcreteSubject observable = new ConcreteSubject();
        Observer o1 = new ConcreteObserver1(observable);
        Observer o2 = new ConcreteObserver2(observable);
        Observer o3 = new ConcreteObserver3(observable);

        observable.setState("Design Patterns - Hoorah");

        String expectedStdOut = "68 101 115 105 103 110 32 80 97 116 116 101 114 110 115 32 45 32 72 111 111 114 97 104\n"+
                                "44 65 73 69 67 6e 20 50 61 74 74 65 72 6e 73 20 2d 20 48 6f 6f 72 61 68\n"+
                                "harooH - snrettaP ngiseD\n";

        assertEquals(expectedStdOut, outContent.toString());


    }

    @Test
    public void shouldUpdateOnlyFirstObserver(){
        ConcreteSubject observable = new ConcreteSubject();
        Observer o1 = new ConcreteObserver1(observable);
        Observer o2 = new ConcreteObserver2(observable);
        Observer o3 = new ConcreteObserver3(observable);
        observable.detach(o2);
        observable.detach(o3);
        observable.setState("Design Patterns - Hoorah");

        String expectedStdOut = "68 101 115 105 103 110 32 80 97 116 116 101 114 110 115 32 45 32 72 111 111 114 97 104\n";
        assertEquals(expectedStdOut, outContent.toString());
    }

    @Test
    public void shouldObserveEmptyStateOfObservable(){
        ConcreteSubject observable = new ConcreteSubject();
        Observer o1 = new ConcreteObserver1(observable);
        Observer o2 = new ConcreteObserver2(observable);
        Observer o3 = new ConcreteObserver3(observable);
        observable.setState("");

        String expectedStdOut = "\n\n\n";
        assertEquals(expectedStdOut, outContent.toString());
    }

    @Test
    public void onlyTwoObserverShouldBeUpdated(){
        ConcreteSubject observable = new ConcreteSubject();
        Observer o1 = new ConcreteObserver1(observable);
        Observer o2 = new ConcreteObserver2(observable);
        Observer o3 = new ConcreteObserver3(observable);
        observable.detach(o2);
        observable.setState("hi, how are you?");

        String expectedStdOut = "104 105 44 32 104 111 119 32 97 114 101 32 121 111 117 63\n";
        expectedStdOut += "?uoy era woh ,ih\n";
        assertEquals(expectedStdOut, outContent.toString());
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointExceptionIfObservableStateIsNull(){
        ConcreteSubject observable = new ConcreteSubject();
        Observer o1 = new ConcreteObserver1(observable);
        Observer o2 = new ConcreteObserver2(observable);
        Observer o3 = new ConcreteObserver3(observable);
        observable.setState(null);
    }

}
