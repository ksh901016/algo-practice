package queue;

public class IntDeque {
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

    public IntDeque(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[capacity];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    // 덱(deck)에 데이터를 머리쪽부터 인큐
    public int enqueFront(int x){
        if(num >= max){
            throw new OverflowIntQueueException();
        }
        num++;
        if(--front < 0){
            front = max - 1;
        }
        que[front] = x;
        return x;
    }

    // 덱(deck)에 데이터를 꼬리쪽부터 인큐
    public int enqueRear(int x){
        if(num >= max){
            throw new OverflowIntQueueException();
        }
        num++;
        que[rear++] = x;
        if(rear >= max){
            rear = 0;
        }
        return 0;
    }

    // 덱(deck) 머리쪽부터 데이터를 디큐
    public int dequeFront(){
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        int x = que[front++];
        num--;
        if(front >= max){
            front = 0;
        }
        return x;
    }

    // 덱(deck) 꼬리쪽부터 데이터를 디큐
    public int dequeRear(){
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        num--;
        if(--rear >= 0){
            rear = max - 1;
        }
        return que[rear];
    }

    // 덱(deck)의 머리부터 데이터를 피크
    public int peekFront(){
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    // 덱(deck)의 꼬리부터 데이터를 피크
    public int peekRear(){
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        return que[rear == 0 ? max -1 : rear - 1];
    }

    // 덱(deck)에서 x를 검색하여 index 를 반환
    public int indexOf(int x){
        for(int i=0; i<num; i++){
            final int index = (front + i) % max;
            if(que[index] == x){
                return index;
            }
        }
        return -1;
    }

    // 덱(deck)에서 x를 검색하여 머리부터 몇 번 째인가를 반환
    public int search(int x){
        for(int i=0; i<num; i++){
            if(que[(front + i) % max] == x){
                return i + 1;
            }
        }
        return 0;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("덱(deck)이 비었습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }
}
