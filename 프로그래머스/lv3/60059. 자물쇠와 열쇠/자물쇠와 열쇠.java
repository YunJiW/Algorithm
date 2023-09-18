class Solution {
    public boolean solution(int[][] key, int[][] lock) {

        int point = key.length - 1;
        for (int x = 0; x < point + lock.length; x++) {
            for (int y = 0; y < point + lock.length; y++) {

                for (int r = 0; r < 4; r++) {
                    int[][] newLock = new int[key.length * 2 + lock.length][key.length * 2 + lock.length];

                    for (int i = 0; i < lock.length; i++) {
                        for (int j = 0; j < lock.length; j++) {
                            newLock[i+point][j+point] = lock[i][j];
                        }
                    }
                    match(newLock,key,r,x,y);
                    //자물쇠의 빈 곳이 없을 경우 -> 맞음.
                    if(check(newLock,point,lock.length))
                        return true;
                }
            }
        }
        return false;
    }

    //열쇠를 움직이며 빈칸 채우기
    //회전 체크
    private void match(int[][] newLock, int[][] key, int rotation, int x, int y) {
        int len = key.length;

        for(int row = 0; row <len; row++)
        {
            for(int col = 0; col < len ; col++ ){
                switch (rotation){
                    case 0:
                        newLock[x+row][y+col] += key[row][col];
                        break;
                    case 1:
                        newLock[x+row][y+col] += key[col][len-row-1];
                        break;
                    case 2:
                        newLock[x+row][y+col] += key[len - row -1][len - col - 1];
                        break;
                    case 3:
                        newLock[x+row][y+col] += key[len - col -1][row];
                        break;
                }

        }
        }
    }

    //자물쇠 빈곳이 없는지 체크
    private boolean check(int[][] newLock,int point,int len){
        for(int row =0; row <len;row++){
            for(int col =0; col< len;col++){
                if(newLock[point+row][point+col] != 1) return false;
            }
        }
        return true;
    }
}