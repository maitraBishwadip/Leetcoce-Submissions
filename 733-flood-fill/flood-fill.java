import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayDeque;

class Solution {

    public static class Coordinate
        {
            int r;
            int c;

            public Coordinate( int r ,  int c)
            {
                this.r = r;
                this.c = c;
            }
        }

 public static List<Coordinate> getNeighbour(
    int[][] image,int rowNum, int colNum, Coordinate node, int rootColor
    )
    {
        List<Coordinate> neighbours = new ArrayList<>();

        int[] delta_row = {-1,0,1,0};
        int[] delta_col = {0,1,0,-1};

        for( int i =0 ; i < delta_row.length ; i++)
            {
                int neighbour_row = node.r + delta_row[i];
                int neighbour_col = node.c + delta_col[i];

                if(0 <= neighbour_row && rowNum > neighbour_row && 0 <= neighbour_col && colNum > neighbour_col )
                {
                    if(image[neighbour_row][neighbour_col] == rootColor)
                    {
                        neighbours.add(new Coordinate(neighbour_row,neighbour_col));
                    }
                }
            }
        return neighbours;
    }

    public static  void bfs(int[][] image, int rowNum , int colNum, int replacement,Coordinate root)
    {
        boolean[][] visited = new boolean[rowNum][colNum];
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();

        visited[root.r][root.c] = true;
        queue.add(root);

        int rootColor = image[root.r][root.c];
        image[root.r][root.c] = replacement;

        while(queue.size() > 0)
            {
                Coordinate node = queue.pop();

                List<Coordinate> neighbours = getNeighbour( image,rowNum, colNum,  node,  rootColor);

                for(Coordinate neighbour : neighbours)
                    {
                        if(visited[neighbour.r][neighbour.c]== true) continue;

                         image[neighbour.r][neighbour.c] = replacement;

                        visited[neighbour.r][neighbour.c]= true;
                        queue.add(neighbour);
                    }
            }
        
    }
    public static int[][] floodFill(int[][] image,int r, int c, int replacement) {
        // WRITE YOUR BRILLIANT CODE HERE


        



    
      

        int rowNum = image.length;
        int colNum = image[0].length;
        

        // Avoid infinite loop if color is already the replacement
       // if (rootColor == replacement) return image;

        // 2. Run your BFS (using your existing logic)
        bfs(image, rowNum, colNum, replacement, new Coordinate(r, c));

        // 3. Convert List<List<Integer>> back to int[][] using Streams
        return image;
            
    
    }

}

   