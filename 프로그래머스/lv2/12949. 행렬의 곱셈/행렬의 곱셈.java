class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr2[0].length;

        int[][] answer = new int[rows][cols];

        System.out.println("rows :" + rows + "  " + "cols : " + cols);


        for(int new_row = 0; new_row <rows;new_row++){
            for(int new_col = 0; new_col < cols; ){
                for(int k = 0; k<arr1[0].length;k++){
                    answer[new_row][new_col] += (arr1[new_row][k] * arr2[k][new_col]);
                }
                new_col+=1;
            }

        }



        return answer;
    }
}