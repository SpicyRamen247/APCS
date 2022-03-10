// Team McDonalds$24MScam: Prattay Dey, Joshua Gao, Faiza Huda
// Ducks : Winnie, Batman, Truthful Tom, Huebert
// APCS pd08
// 2022-03-08
// time spent: 1.5 hrs

/*
ALGO:
- Building it recursively by comparing the pivot to the yth smallest number.
- We reduce the search space until it reaches the base case.
- The base case is if the pivot is equal to the yth smallest number.
- Then return, the value of the array at pivot index

BEST CASE SCENARIO: If array is already sorted in ascending order, just return array[y]. We would need to iterate only once through the array, so it would be O(n).
WORST CASE SCENARIO: Having to iterate through the entire array before reaching the yth smallest number, which would be O(n) * O(n), or O(n^2)

DISCOS:
- Fast select was similar to Binary Search in that it narrows the search space until you reach the desired target
- Solution set for kth smallest element is mapped onto the same solution set for pivot
- There is no need for sorting of the array since every element to the left of the pivot is always less than every element to the right of the pivot, including the pivot value itself
- Our algorithm exploits pivot as our invariance
- https://www.cnbc.com/2020/02/07/how-mcmillions-scam-rigged-the-mcdonalds-monopoly-game.html

QCC:
- The initial lower and upper bound does not matter since we are initally taking into account the entire array
*/

public class FastSelect{
    public static int partition(int[] arr, int a, int b, int c){
    int v = arr[c];
    swap(arr, c, b);
    int s = a;
    for(int i = a; i<b; i++){
      if (arr[i] < v){
        swap(arr, s, i);
        s++;
      }
    }
    swap(arr, b, s);
    return s;
  }

  public static void swap(int[] arr, int a, int b){
    int old = arr[a];
    arr[a] = arr[b];
    arr[b] = old;
  }

  // yth smallest element
  public static int fastselect(int[] arr, int lower, int upper, int y){
    // checks to see if it is in range of the number of elements in the array
    if (y > 0 && y < arr.length){
      // final index is the pivot
      int finalIndex = partition(arr, 0, arr.length - 1, y);
      // base case / best case
      // After a paritition, we know that the finalIndex (pivot) will be in its sorted position.
      // finalIndex is the invariant, meaning that it does not change
      if (finalIndex == y){
        return arr[finalIndex - 1];
      }
      // if pivot is greater, set another partition to the left of the index
      if (finalIndex > y){
        return fastselect(arr, 0, finalIndex, y);
      }
      // if pivot is less, set another partition to the right of the index
      if (finalIndex < y){
        return fastselect(arr, finalIndex + 1, arr.length, y);
      }
    }
    // if y is more than the num of elements in the int array
    return -1;
  }

  public static void main(String[] args){
    // standard case
    int[] array1 = {7,1,5,12,3};
    System.out.println(fastselect(array1, 0, 5, 2)); // result 3

    // best case for yth smallest num is if array is already sorted, just return array[y]
    int[] array2 = {0,1,2,3,4,5};
    System.out.println(fastselect(array2, 0, 6, 2)); // result 1

    // worst case would be having to iterate thru entire array before finding yth smallest num
    int[] array3 = {23,5,7,19,3};
    System.out.println(fastselect(array3, 0, 5, 1));
  }
}