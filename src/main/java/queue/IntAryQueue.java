package queue;

import java.util.Arrays;

// 배열로 큐 만들기
public class IntAryQueue {
    private int max; // 큐 용량
    private int num; // 현재 데이터 수
    private int[] que; // 큐 본체

    private int front;
    private int rear;

    // 예외 : 큐가 비어 있음
    class EmptyIntQueueException extends RuntimeException{
    }
    // 예외 : 큐가 가득 참
    class OverflowIntQueueException extends RuntimeException{
    }

    public IntAryQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try {
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
        return x;
    }

    public int deque(){
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        int value = que[front];
        que = Arrays.copyOfRange(que, front + 1, rear--);
        num--;
        return value;
    }

    public void print(){
        for(int data : que){
            System.out.println("data : " + data);
        }
    }

    public int[] getQue(){
        return que;
    }

    public int size(){
        return num;
    }
}
