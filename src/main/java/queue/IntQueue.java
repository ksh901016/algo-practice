package queue;

public class IntQueue {
    private int max;
    private int num;
    private int[] que;

    private int front;
    private int rear;

    // 예외 : 큐가 비어 있음
    class EmptyIntQueueException extends RuntimeException{
    }
    // 예외 : 큐가 가득 참
    class OverflowIntQueueException extends RuntimeException{
    }

    public IntQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[capacity];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int enque(int x){
        if(num >= max){
            throw  new OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;

        if(rear == max){
            rear = 0;
        }
        return x;
    }

    public int deque(){
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        int x = que[front++];
        num--;

        if(front == max){
            front =0;
        }
        return x;
    }

    public int peek(){
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    public int indexOf(int x){
        for(int i=0; i<num; i++){
            int index = (front + i) % max;
            if(que[index] == x)
                return index;
        }

        return -1;
    }
}
