package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DequeTest {
    private IntDeque intDeque = new IntDeque(5);

    @Test
    void enqueTest(){
        intDeque.enqueFront(1);
        intDeque.enqueFront(2);
        intDeque.enqueFront(3);
        intDeque.enqueFront(4);
        Assertions.assertEquals(1, intDeque.indexOf(4));

        intDeque.enqueRear(5);
        intDeque.dump();
        Assertions.assertEquals(0, intDeque.indexOf(5));
        Assertions.assertEquals(5, intDeque.search(5));
    }
}
