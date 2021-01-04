package sort;

public class SortUtil {
    static void swap(int a[], int index1, int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
