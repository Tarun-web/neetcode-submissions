class Solution {
    public boolean isPossible(char[][] m, int i, int j){

        int el = m[i][j];

        // check for row
        for(int r=0; r<9; r++){
            if(r != i && m[r][j] == el) return false;
        }

        // check for col
        for(int c=0; c<9; c++){
            if(c != j && m[i][c] == el) return false;
        }

        // check for box
        int row = (i/3) * 3;
        int col = (j/3) * 3;
        for(int r=row; r<row+3; r++){
            for(int c=col; c<col+3; c++){
                if((r != i || c != j) && m[r][c] == el) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.' && !isPossible(board, i, j)){
                    return false;
                }
            }

        }

        return true;
    }
}
