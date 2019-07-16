class Solution {

    // i think this is the clearest
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    // this is my solution
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        int i, j;
        
        // validate row
        for (i = 0; i<9; ++i){
            set.clear();
            for (j = 0; j<9; ++j){
                if (!set.add(board[i][j]) && board[i][j]!='.'){
                    return false;
                }    
            }
        }
        
        // validte colunm
        for (i = 0; i<9; ++i){
            set.clear();
            for (j = 0; j<9; ++j){
                if (!set.add(board[j][i]) && board[j][i]!='.'){
                    return false;
                }
            }
        }
        
        // valiaten sub-boxes
        for(i = 0; i < 7; i+=3){
            for(j = 0; j<7; j+=3){
                set.clear();
                // check each section  
                System.out.println("===============");
                for (int m = 0; m < 3; ++m){
                    for (int n = 0; n < 3; ++n){
                        if (!set.add(board[i+m][j+n]) && board[i+m][j+n]!='.'){
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}