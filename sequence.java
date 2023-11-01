public class sequence {
  
  public static int[] getSequenceMax(int[] array, int difference) {
    int[] returnArray = {0,0};
    boolean keep, within, breakLoop = true;
    int first = 0, last = 0, tempdiff1, tempdiff2;
    while (breakLoop) {
      keep = false;
      for (int i = last; i + 1 < array.length; i++) {
        tempdiff1 = array[i] - array[i+1];
        tempdiff2 = array[i+1] - array[i];
        within = (tempdiff1 <= difference && tempdiff1 >= 0) || (tempdiff2 <= difference && tempdiff2 >= 0);
        if (within) {
          if (!keep) {
            first = i;
          }
          last = i + 1;
          keep = true;
        } else if (keep) {
          last = i;
          break;
        }
        if (!(i + 2 < array.length)) {
          breakLoop = false;
        }
        if (last - first > returnArray[1] - returnArray[0]) {
          returnArray[0] = first;
          returnArray[1] = last;
        }
      }
    }
    return returnArray; 
    }
  public static void main(String[] args) {
    int[] array = {0,0,3,4,3,3};
    int difference = 1;
    int[] output = getSequenceMax(array, difference);
    for (int i : output) {
      System.out.println(i);
    }
  }
}
