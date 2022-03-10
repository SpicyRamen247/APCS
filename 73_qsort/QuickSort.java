public class qSort {
    //sort method
    public static void qSort (int[] d) {
        qSort(d,0,d.length-1);
    }
}

//helper method
public static void qSort(int[] d, int begin, int end) {
    if (end > begin) {
        int pivotIndex = partition(d, begin, end);
        //recursive call
        qSort(d, begin, pivotIndex-1);
        qSort(d, pivotIndex+1, end);
    }
}

//partitioning of array
public static int partition(int[] d, begin, end) {
    //Choose beginning element (1st element) as pivot
    int pivot = d[begin];
    //Forward search index
    int low = begin + 1;
    //Backward search index
    int high = last; 

    while (high > low) {
        while (low<=high && d[low] <= pivot)
        //forward
        low++;
    }

    while (low<=high && d[high]>pivot)
    //backward
    high--;

    if (high>low) {
        int temp = d[high];
        //Swapping 2 elements in the list
        list[high] = list[low];
        list[low] = temp;
    }
    while (high>first && d[high] >= pivot)
    high--;

    if (pivot>d[high]) {
        d[first]=d[high];
        //Place pivot
        d[high]=pivot;
        //Pivot's new index
        return high;
    }
    else {
        //Pivot's OG index
        return first;
    }
}
public static void main(String[] args) {
    int[] d = {4,12,1,4,-1,7,10,15};
    qSort(d);
    for (int i =0; i <d.length; i++) {
        System.out.print(d[i] + " ");
    }
}