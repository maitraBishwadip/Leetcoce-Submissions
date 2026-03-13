class Solution {
  
  public char[][]  board;
  public int rows;
  public int cols;




    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;


        for(int i = 0 ; i< rows ; i++)
        {
            for(int j = 0 ; j< cols ; j++)
            {
                if(backTrack(i,j,word,0))
                return true;
            }
        }
        return false;
        
    }

    public boolean backTrack( int row , int col , String word, int index){
    {
        if(index >= word.length())
        return true;
    }

    if(row < 0 || row >= rows || col < 0 || col >= cols || this.board[row][col] != word.charAt(index)){
            return false;
        }

    int [] rowDir = {0,1,0,-1};
    int [] colDir = {1,0,-1,0};

    this.board[row][col] = '#';

    boolean ret = false;

    for(int d=0 ;d<4 ; d++)
    {
        ret = backTrack(row+ rowDir[d], col+ colDir[d], word, index+1);

        if(ret)
        {
            break;
        }
    }

    board[row][col] = word.charAt(index);
    return ret;
    }

}
