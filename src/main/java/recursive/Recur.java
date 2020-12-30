package recursive;

import stack.IntStack;

import java.util.Scanner;

public class Recur {
    // 재귀 함수
    static void recur(int n){
        if(n > 0){
            recur(n-1);
            System.out.print(n + "\t");
            recur(n-2);
        }
    }

    // 꼬리 재귀 제거
    static void recurRemoveTail(int n){
        while(n > 0){
            recurRemoveTail(n-1);
            System.out.print(n + "\t");
            n = n-2;
        }
    }

    // 재귀 제거
    static void recurRemoveRecur(int n){
        IntStack stack = new IntStack(n);
        while(true){
            if(n>0){
                stack.push(n);
                n = n-1;
                continue;
            }
            if(!stack.isEmpty()){
                n = stack.pop();
                System.out.print(n + "\t");
                n = n - 2;
                continue;
            }
            break;
        }
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("정수를 입력하세요.:");
        int x = stdIn.nextInt();

        recur(x);
        System.out.println();
        recurRemoveTail(x);
        System.out.println();
        recurRemoveRecur(x);
    }
}
