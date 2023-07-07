class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int min_row= Integer.MAX_VALUE;
        int min_col = Integer.MAX_VALUE;

        int max_row =Integer.MIN_VALUE;
        int max_col= Integer.MIN_VALUE;


        for(int row =0; row <wallpaper.length;row++){
            for(int col =0; col < wallpaper[0].length();col++){
                char item = wallpaper[row].charAt(col);
                if(item != '#'){
                    continue;
                }
                min_row = Math.min(min_row,row);
                min_col = Math.min(min_col,col);

                max_row = Math.max(max_row,row+1);
                max_col = Math.max(max_col,col+1);


            }
        }
        answer[0] = min_row;
        answer[1] = min_col;
        answer[2] = max_row;
        answer[3] = max_col;



        return answer;
    }
}