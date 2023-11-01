public class matrix {

  public static int solution(int[][] matrix, int framesize) {
    int total = 0, max = 0;
    int difference = matrix.length - framesize;
    for (int i = 0; i <= difference; i++) {
      for (int j = 0; j <= difference; j++) {
        total = getPerimeter(matrix, framesize, i, j);
        if (total > max) {
          max = total;
        }
      }
    }
    return max;
  }
  public static int getPerimeter(int[][] matrix, int framesize, int rowbuffer, int columnbuffer) {
    int total = 0;
    for (int i = rowbuffer; i < framesize + rowbuffer; i++) {
      for (int j = columnbuffer; j < framesize + columnbuffer; j++) {
        if ((i == rowbuffer) || (i == framesize + rowbuffer - 1)) {
          total += matrix[i][j];
        } else {
          total += matrix[i][columnbuffer] + matrix[i][framesize + columnbuffer - 1];
          break;
        }
      }
    }
    return total;
  }
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4,5},
                      {5,4,3,2,1},
                      {8,2,9,9,9},
                      {6,4,9,5,9},
                      {2,5,9,9,9}};
    //int[][] matrix2 = {{1}};
    //int[][] matrix3 = {{1,2},
    //                   {4,5}};
    System.out.println("\u001b[H\u001b[2J");
    System.out.println(solution(matrix, 3));

  }
}
