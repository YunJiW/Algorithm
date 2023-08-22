class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int sum[][] = new int[board.length+1][board[0].length+1];

        //skill만큼 건물 진행
        for(int test = 0;test <skill.length;test++){
            int type = skill[test][0];
            int r1 = skill[test][1];
            int c1 = skill[test][2];
            int r2 = skill[test][3];
            int c2 = skill[test][4];
            int degree = skill[test][5];
            //1 공격
            if(type == 1){
                sum[r1][c1] -= degree;
                sum[r1][c2+1] += degree;
                sum[r2+1][c1] += degree;
                sum[r2+1][c2+1] -=degree;
                //2 회복
            }else{
                sum[r1][c1] += degree;
                sum[r1][c2+1] -= degree;
                sum[r2+1][c1] -= degree;
                sum[r2+1][c2+1] +=degree;
            }
        }

        //행 계산
        for(int row = 0; row < sum.length;row++){
            for(int col = 0; col <sum[0].length-1;col++){
                sum[row][col+1] += sum[row][col];
            }
        }
        
        //열계산
        for(int col = 0; col < sum[0].length;col++){
            for(int row =0; row <sum.length-1;row++){
                sum[row+1][col] += sum[row][col];
            }
        }
        answer = result(board,sum);

        return answer;
    }


    //파괴되지않은 건물 개수 계산
    public int result(int [][] board,int[][] sum){
        int count = 0;

        for(int row =0 ;row <board.length;row++){
            for(int col = 0; col<board[0].length;col++){
                if(board[row][col] + sum[row][col] >= 1){
                    count+=1;
                }
            }
        }

        return count;
    }
}