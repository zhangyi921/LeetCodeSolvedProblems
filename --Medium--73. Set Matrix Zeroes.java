class Solution {
    // my solution  beats 100.00 % of java submissions.
    // it also meets the requirment of not using any data structure
    public void setZeroes(int[][] matrix) {
        setZeroes(matrix, 0, 0);
    }
    
    public void setZeroes(int[][] matrix, int row, int col){
        for (; row < matrix.length; ++row){
            for (; col < matrix[0].length; ++col){
                if (matrix[row][col] == 0){
                    // use recursion to continue so that we don't need to store
                    // the information in any data structure
                    // set this row to 0
                    // set this col to 0
                    
                    setZeroes(matrix, row, col+1);
                    Arrays.fill(matrix[row], 0);
                    for (int r = 0; r < matrix.length; ++r)
                        matrix[r][col] = 0;
                    return;
                }
            }
            col = 0;
        }
    }
}