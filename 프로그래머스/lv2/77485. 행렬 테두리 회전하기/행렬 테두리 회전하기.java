class Solution {

    static int map[][];

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        map = new int[rows][columns];
        
        //맵 생성
        int num = 1;
        for(int row=0; row <rows;row++){
            for(int col = 0; col<columns;col++){
                map[row][col] = (row * (columns)+ col+1);
            }
        }

        for(int idx =0 ; idx < queries.length;idx++){
            //범위 체크
            int start_row = queries[idx][0];
            int start_col = queries[idx][1];
            int end_row = queries[idx][2];
            int end_col = queries[idx][3];

            int min = Rotate(start_row-1,start_col-1,end_row-1,end_col-1);
            answer[idx] = min;
        }
        



        return answer;
    }


    private int Rotate(int startRow, int startCol, int endRow, int endCol) {


        int last_num = 0;
        int before = map[startRow][startCol];
        int min = before;
        //맨위 (startRow,startCol) -> (startRow,endCol)
        for(int top = startCol; top <endCol;top++){
            last_num = map[startRow][top+1];
            map[startRow][top+1] = before;
            before = last_num;


            min =Math.min(min,last_num);
        }

        //이러면 last_num에 마지막의 값이 존재함.

        //오른쪽 -> 아래로
        for(int right = startRow+1; right<= endRow;right++){
            before = last_num;
            last_num = map[right][endCol];
            map[right][endCol] = before;
            min =Math.min(min,last_num);
        }
        
        //아래 -> 왼쪽으로
        for(int bottom = endCol; bottom > startCol;bottom--){
            before = last_num;
            last_num = map[endRow][bottom-1];
            map[endRow][bottom-1] = before;
            min =Math.min(min,last_num);
        }
        
        //왼쪽
        for(int left = endRow-1; left > startRow;left--){
            before = last_num;
            last_num = map[left][startCol];
            map[left][startCol] = before;
            min =Math.min(min,last_num);
        }
        map[startRow][startCol] = last_num;
        min =Math.min(min,last_num);

        return min;
    }
}