package sanghavis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   @Test
    public void canCreateEmptyQueue(){
       Queue<Integer> queue = new QueueAdapter<>();
       assertNull(queue.peek());
   }

   @Test
    public void canAddElementToQueue(){
       Queue<Integer> queue = new QueueAdapter<>();
       queue.add(12);
       assertEquals(12,(int)queue.peek());
   }

    @Test
    public void canAddMultipleElementToQueue(){
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(12);
        queue.add(21);
        queue.add(22);
        queue.add(10);
        assertEquals(10,(int)queue.peek());
    }

    @Test
    public void canRemoveElementFromEmptyQueue(){
       Queue<Integer> queue = new QueueAdapter<>();
       assertNull(queue.remove());
    }

    @Test
    public void canRemoveElementFromQueue(){
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(12);
        assertEquals(12,(int)queue.remove());
        assertNull(queue.remove());
    }

    @Test
    public void canRemoveMultipleElementsFromQueue(){
       Queue<Integer> queue = new QueueAdapter<>();
       queue.add(12);
       queue.add(10);
       queue.add(32);
       queue.add(22);
       assertEquals(12,(int)queue.remove());
       assertEquals(10,(int)queue.remove());
       assertEquals(32,(int)queue.remove());
       assertEquals(22,(int)queue.remove());
       assertNull(queue.remove());
    }

    @Test
    public void canCreateQueueOfMultipleType(){
       Queue queue = new QueueAdapter();
       String q1 = "hello";
       int q2 = 322;
       double q3 = 322.22;
       queue.add(q1);
       queue.add(q2);
       queue.add(q3);
       assertEquals(q1,queue.remove());
       assertEquals(q2,queue.remove());
       assertEquals(q3,queue.remove());
       assertEquals(null,queue.remove());
    }
}
