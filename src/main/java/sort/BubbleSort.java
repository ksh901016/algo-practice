package sort;

import java.util.Scanner;

public class BubbleSort {

    static void bubbleSortVersion1(int a[], int n){
        for(int i = 0; i < n-1; i++){
            for(int j = n-1; j > i; j--){
                if(a[j-1] > a[j]){
                    SortUtil.swap(a, j - 1, j);
                }
            }
        }
    }

    // 이미 정렬이 되어있어서, 교환을 하지 않았다면 정렬을 중지한다.
    static void bubbleSortVersion2(int a[], int n){
        for(int i = 0; i < n-1; i++){
            int exchange = 0;
            for(int j = n-1; j > i; j--){
                if(a[j-1] > a[j]){
                    SortUtil.swap(a, j - 1, j);
                    exchange++;
                }
            }
            if(exchange == 0) break;
        }
    }

    static void bubbleSortVersion3(int a[], int n){
        int k = 0;
        while(k < n-1){
            int last = n-1; // 마지막으로 요소를 교환한 위치
            for(int j = n-1; j > k; j--){
                if(a[j-1] > a[j]){
                    SortUtil.swap(a, j-1, j);
                    last = j;
                }
            }
            k = last;
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전1)");
        System.out.print("요소 수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++){
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
        bubbleSortVersion2(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++){
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
