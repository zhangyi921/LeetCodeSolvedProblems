class Solution {

    // Your memory usage beats 99.48 % of java submissions
    public void rotate(int[][] matrix) {
        LinkedList<Integer> list = new LinkedList<>();
        int i, j;
        
        // get all numbers in the matrix
        // left to right, top to bottom
        for (i = 0; i < matrix.length; ++i){
            for(j = 0; j < matrix.length; ++j){
                list.add(matrix[i][j]);
            }
        }
        
        // put numbers in the matrix
        // right to left, top to bottom
        for (i = matrix.length-1; i > -1 ; --i){
            for(j = 0; j < matrix.length; ++j){
                matrix[j][i] = list.poll();
            }
        }
    }
    
    
}