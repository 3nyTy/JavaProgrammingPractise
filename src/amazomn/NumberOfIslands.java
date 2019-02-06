package amazomn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    Queue<ArrayList<Integer>> islandQueue;


    public int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here
        int count = 0;
        int rows = binaryMatrix.length;
        int col = binaryMatrix[0].length;
        for (int i= 0; i< rows; i++) {
          for (int j= 0;j < col ; j++) {
            if (binaryMatrix[i][j] == 1) {             
               markIsland(binaryMatrix, rows, col, i, j);
              count ++;
            }           
            
          }
        }
        return count;
        
      }

      public void markIsland(int[][] binaryMatrix, int rows, int col, int i, int j) {
         /* arr.add(i);
          arr.add(j);
          islandQueue = new LinkedList<ArrayList<Integer>>();
          islandQueue.add(arr);
          while (!islandQueue.isEmpty()) {
              ArrayList<Integer> num = islandQueue.poll(); // 0,3 
              // 0,4 ; 1,3 ; 0,2
              int x = num.get(0), y = num.get(1);
              if (binaryMatrix[x][y] == 1) {
                  binaryMatrix[x][y] = -1;
                  pushIfValid(islandQueue, rows, col, x - 1, y);
                  pushIfValid(islandQueue, rows, col, x , y - 1);
                  pushIfValid(islandQueue, rows, col, x + 1, y);
                  pushIfValid(islandQueue, rows, col, x , y + 1);
                
              }
             
            }*/
          if (i < 0 || j < 0 || i >= rows || j >= col || binaryMatrix[i][j] != 1) return;
          binaryMatrix[i][j] = 0;
          markIsland(binaryMatrix, rows, col, i + 1, j);
          markIsland(binaryMatrix, rows, col, i - 1, j);
          markIsland(binaryMatrix, rows, col, i, j + 1);
          markIsland(binaryMatrix, rows, col, i, j - 1);

          
          
    }

    public  void pushIfValid(Queue<ArrayList<Integer>> islandQueue, int rows, int col, int x, int y) {
          if (x >= 0 && x < rows && y >= 0 && y < col) {
              arr.add(x);
              arr.add(y);
              islandQueue.add(arr);
          }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,1,0,1,0},{0,0,1,1,1},{1,0,0,1,0},{0,1,1,0,0},{1,0,1,0,1}};
        int out = new NumberOfIslands().getNumberOfIslands(test);
        System.out.println(out);
      }


}
