/**
LYJ: Lawrence Joa, Joshua Gao, Yat Long Chan
APCS
HW34 -- A Pirate's life for Me // methods using int arrays
2021-11-12
time spent: 0.7 hours
DISCO
- array.length does not have parentheses at the end, meaning it is not a method.
- Arrays.copyOf() is used to make a copy of an array or a section of an array starting from index 0

QCC
- We had to use a helper method for linSearchR().
- What should be the range in randArr() or method that populates the array randomly?
**/

import java.util.Arrays;

public class Loopier{

  //populate array with randInts
  public static void randArr(int[] a){
    for(int i=0; i<a.length; i++){
      a[i] = (int)(Math.random() * 100);
    }
  }

  //toString
  public static String toString(int[] a){
    String arrStr = "[";
    for(int i=0; i<a.length; i++){
      if (i == a.length - 1){
        arrStr = arrStr + a[i] + "]";
      } else {
        arrStr = arrStr + a[i] + ", ";
      }
    }
    return arrStr;
  }

  // Linear search iteratively
  public static int linSearch(int[] a, int target){
    for (int i = 0; i < a.length; i ++){
      if (a[i] == target){
        return i;
      }
    }
    return -1;
  }

  // Linear search recursively.
  public static int linSearchR(int[] a, int target){
    return linSearchRHelper(a, 0, target);
  }

  // So you don't have to enter index when calling linSearchR() itself.
  public static int linSearchRHelper(int[] a, int index, int target){
    int end = a.length -1;
    if (a[index] == target){
      return index;
    }
    if (end <= index){
      return -1;
    }
    return linSearchRHelper(a, index + 1, target);
  }

  //iterative frequency of target
  public static int freq(int[] a, int target){
    int count = 0;
    for (int i = 0; i < a.length; i ++){
      if (a[i] == target){
        count ++;
      }
    }
    return count;
  }

  //recursive frequency of a target
  public static int freqRec(int[] a, int target){
    if (a.length == 0){
      return 0;
    }

    int[] newA = Arrays.copyOf(a, a.length -1);

    if (a[a.length -1] == target){
      return 1 + freqRec(newA, target);
    } else {
      return 0 + freqRec(newA, target);
    }
  }

  public static void main(String[] args){
    int[] x = new int[]{};
    int[] y = new int[]{1, 2, 2};
    Loopier hi = new Loopier();
    System.out.println(hi.linSearchR(y, 3)); //print -1
    System.out.println(hi.linSearchR(y, 2)); //print 1
    System.out.println(hi.freq(x, 1)); //print 0
    System.out.println(hi.freqRec(x, 1)); //print 0
    System.out.println(hi.freq(y, 2)); //print 2
    System.out.println(hi.freqRec(y, 2)); //print 2
  }
}