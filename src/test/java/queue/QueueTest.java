package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QueueTest {
    private IntAryQueue intAryQueue = new IntAryQueue(5);

    @Test
    void enqueTest(){
        intAryQueue.enque(1);
        intAryQueue.enque(2);
        intAryQueue.enque(3);
        intAryQueue.enque(4);
        intAryQueue.enque(5);
        intAryQueue.print();
        Assertions.assertThrows(IntAryQueue.OverflowIntQueueException.class, () -> intAryQueue.enque(6));
    }

    @Test
    void dequeTest(){
        intAryQueue.enque(1);
        intAryQueue.enque(2);
        intAryQueue.enque(3);
        intAryQueue.enque(4);
        intAryQueue.enque(5);
        Assertions.assertEquals(1, intAryQueue.deque());
        Assertions.assertArrayEquals(new int[]{2,3,4,5}, intAryQueue.getQue());
        intAryQueue.print();
        int size = intAryQueue.size();
        for(int i=0; i<size; i++){
            intAryQueue.deque();
        }
        intAryQueue.print();
        Assertions.assertThrows(IntAryQueue.EmptyIntQueueException.class, intAryQueue::deque);
    }
}
