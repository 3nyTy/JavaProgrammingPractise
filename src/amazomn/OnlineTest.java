package amazomn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class OnlineTest
{        
 /*   // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  * 
  * DFS Solution
   static int removeObstacle(int numRows, int numColumns, int[][] lotArr)
    {
        // WRITE YOUR CODE HERE
        int[][] lotArr = new int[numRows][numColumns];
        for(int i = 0 ; i < numRows; i++) {
            for(int j = 0; j < numColumns; j++) {
                lotArr[i][j] = lot.get(i).get(j);
            }
            
        }
        int distance = -1;
        //distance = checkObstacles(lotArr, 0,0);
        
        for(int i = 0 ; i < numRows; i++) {
            for(int j = 0; j < numColumns; j++) {
                if (lotArr[i][j]  == 1) {
                   return checkObstacles(lotArr, i, j, distance);
                   //distance++;
                }
            }
            
        }
      return distance; 
        
    }
    
    public static int checkObstacles(int[][] lotArr, int row, int col, int distance) {
        int numRows = lotArr.length;
        int numCols = lotArr[0].length;
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || lotArr[row][col] == 0) 
        return 0;
        
        if (lotArr[row][col] == 9) return 1;
        
        //lotArr[row][col] = 0;

        if (lotArr[row][col] == 1) {
        lotArr[row][col] = 0;
        return 1;
        }
        
        return checkObstacles(lotArr, row + 1, col, 1) +
        checkObstacles(lotArr, row - 1, col, 1) +
        checkObstacles(lotArr, row, col + 1, 1) +
        checkObstacles(lotArr, row, col - 1, 1);
        //return -1;
    }
*/   
    /**BFS Solution*/
    
    //private static final int EMPTY = Integer.MAX_VALUE;
    private static final int OBSTACLE = 0;
    private static final int ROAD = 1;
    private static final int BUILDING = 9;

    
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    
    // METHOD SIGNATURE ENDS
    public static void main(String[] args) {
      int[][] arr = new int[][] {{1,1,1, 1},{0,1,1, 1},{0,1,0,1},{1,1,9,1}, {0,0,1,1}};
      if(removeObstacle(5, 4, arr) != Integer.MAX_VALUE) {
       System.out.println(removeObstacle(5 , 4, arr));
      } else {
          System.out.println(0);
      }
    }

private static int removeObstacle(int i, int j, int[][] rooms) {
    if (rooms.length == 0) return 0;
    for (int row = 0; row < rooms.length; row++) {
        for (int col = 0; col < rooms[0].length; col++) {
            if (rooms[row][col] == ROAD) {
                return distanceToNearestGate(rooms, row, col);
            }
        }
    }
    return 0;
}

private static int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
    int m = rooms.length;
    int n = rooms[0].length;
    int[][] distance = new int[m][n];
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { startRow, startCol });
    while (!q.isEmpty()) {
        int[] point = q.poll();
        int row = point[0];
        int col = point[1];
        for (int[] direction : DIRECTIONS) {
            int r = row + direction[0];
            int c = col + direction[1];
            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] == OBSTACLE
               ) {
                continue;
            }
            distance[r][c] = distance[row][col] + 1;
            if (rooms[r][c] == BUILDING) {
                return distance[r][c];
            }
            q.add(new int[] { r, c });
        }
    }
    return Integer.MAX_VALUE;
}

}