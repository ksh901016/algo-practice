package stack;

public class IntStack {
    private int max; // 스택 용량
    private int ptr; // 스택 포인터
    private int[] stk; // 스택 본체

    // 예외 : 스택이 비어 있음
    class EmptyIntStackException extends RuntimeException{
    }
    // 예외 : 스택이 가득
    class OverflowIntStackException extends RuntimeException{
    }

    // 생성자
    public IntStack(int capacity){
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int push(int x){
        if(ptr >= max){
            throw new OverflowIntStackException();
        }
        stk[ptr++] = x;
        return x;
    }

    public int pop(){
        if(ptr <= 0){
            throw new EmptyIntStackException();
        }
        return stk[ptr--];
    }

    public int pick(){
        if(ptr <= 0){
            throw new EmptyIntStackException();
        }
        return stk[ptr -1];
    }

    // 선형 검색(꼭대기 -> 바닥)
    public int indexOf(int x){
        for(int i = ptr-1; i>=0; i--){
            if(stk[i] == x){
                return i; // 검색 성공
            }
        }
        return -1; // 검색 실
    }

    public void clear(){
        ptr = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return ptr;
    }

    public boolean isEmpty(){
        return ptr <= 0;
    }

    public boolean isFull(){
        return ptr >= max;
    }
}
