class Solution {
    char map[][];

    int X_sum = 0;
    int O_sum = 0;

    boolean WinO = false;

    boolean WinX = false;

    public int solution(String[] board) {
        int answer = -1;

        map = new char[3][3];
        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {
                char cur = board[row].charAt(col);
                map[row][col] = cur;
                if (cur == 'X') {
                    X_sum += 1;
                } else if (cur == 'O') {
                    O_sum += 1;
                }
            }
        }

        answer = isPossible();


        return answer;
    }

    private int isPossible() {

        //X는 있는데 O가 없는경우 -> 실수
        if (O_sum == 0 && X_sum >= 1) {
            return 0;
        }
        //X가 더 많으면 아웃
        if(X_sum > O_sum)
            return 0;

        //둘의 차이가 2이상인경우 -> 실수
        if (O_sum - X_sum >= 2) {
            return 0;
        }

        checkMap();
        //둘다 승리한경우 -> 불가능
        if (WinO && WinX) {
            return 0;
        }

        if(WinO && O_sum == X_sum)
            return 0;

        //X가 완성됬을때 O가 하나더 있는경우 -> 끝나고도 진행됬음
        if(WinX && O_sum - X_sum >= 1)
            return 0;


        return 1;
    }
    //가로 3개
    //세로 3개
    //대각 2개
    private void checkMap() {
        //가로 체크
        for (int row = 0; row < 3; row++) {
            int cnt = 1;
            char cur = map[row][0];
            if (cur == '.')
                continue;
            for (int col = 1; col < 3; col++) {
                if (cur == map[row][col]) {
                    cnt += 1;
                } else {
                    break;
                }
            }
            if (cnt == 3 && cur == 'O') {
                WinO = true;
            } else if (cnt == 3 && cur == 'X') {
                WinX = true;
            }
        }

        //세로 체크
        for (int col = 0; col < 3; col++) {
            int cnt = 1;
            char cur = map[0][col];
            if(cur == '.')
                continue;
            for (int row = 1; row < 3; row++) {
                if (cur == map[row][col]) {
                    cnt += 1;
                } else {
                    break;
                }
            }
            if (cnt == 3 && cur == 'O') {
                WinO = true;
            } else if (cnt == 3 && cur == 'X') {
                WinX = true;
            }
        }

        //대각 체크 2가지
        char cur = map[0][0];
        if (cur != '.') {
            if (cur == map[1][1] && cur == map[2][2]) {
                if(cur == 'O'){
                    WinO = true;
                }else if(cur == 'X'){
                    WinX = true;
                }

            }
        }
        cur = map[0][2];
        if(cur != '.'){
            if(cur == map[1][1] && cur == map[2][0]){
                if(cur == 'O'){
                   WinO = true;
                }if(cur == 'X'){
                    WinX = true;
                }
            }
        }
    }
}