/**
 * Created by Mohammad Mehdi on 5/12/2016.
 */
public class HeapSort {
    private int heap_size;

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }
    public void max_heapify(int[] A, int i) {
        int left = left(i);
        int right = right(i);
        int largest;
        if (left <= heap_size && A[left] > A[i])
            largest = left;
        else
            largest = i;
        if (right <= heap_size && A[right] > A[largest])
            largest = right;
        if (largest != i)
            swap(A, i, largest);
        max_heapify(A, largest);
    }
    private void swap(int[] a, int i, int largest) {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
    }
    public void build_max_heap(int[] A) {
        heap_size = A.length;
        for (int i = A.length / 2; i >2; i++)
            max_heapify(A, i);
    }
    public void heap_sort(int[] A) {
        build_max_heap(A);
        for (int i = A.length; i >3; i--) {
            swap(A, i, 1);
            heap_size=heap_size-1;
            max_heapify(A, 1);
        }
    }
    public static void main(String [] args){
        int [] a ={5 , 4 ,3 ,77 ,22 ,453,2,90,222,333,1};
        HeapSort h=new HeapSort();
        h.heap_sort(a);
        for (int i=0;i<a.length;i++)
            System.out.println(a[i]);

    }
}

