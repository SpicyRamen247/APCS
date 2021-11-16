/**
LYJ: Lawrence Joa, Joshua Gao, Yat Long Chan
APCS
HW35 --
2021-11-15
time spent: 0.1 hours
DISCO
- nothing new
QCC
- not using imports requires the creation of another method in the case of both recursive methods
**/

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
  
  // Gets a section of array. Used in freqRec
  public static int[] subarray (int[] a, int start, int end){
    int[] sub = new int[end - start];
    for (int i = start; i < end; i ++){
      sub[i - start] = a[i];
    }
    return sub;
  }
  
  // recursive frequency of target
  public static int freqRec(int[] a, int target){
    if (a.length == 0){
      return 0;
    }
    int[] newA = subarray(a, 1, a.length);
    if (a[0] == target){
      return 1 + freqRec(newA, target);
    } else{
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