class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        int row = board.length;
        int col = board[0].length;

        //크기가 1x1인경우 -> 그냥 그값 찍으면됨.
        if (row < 2 || col < 2) {
            return board[0][0];
        }

        int max = 0;
        for (int rows = 1; rows < row; rows++) {
            for (int cols = 1; cols < col; cols++) {
                if (board[rows][cols] != 0) {
                    board[rows][cols] = Math.min(board[rows][cols - 1], Math.min(board[rows - 1][cols - 1], board[rows - 1][cols])) + 1;
                }

                if(answer < board[rows][cols])
                    answer = board[rows][cols];
            }
        }

        return answer*answer;
    }
}