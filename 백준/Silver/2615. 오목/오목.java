import java.util.*;
import java.io.*;

public class Main {

    //19 * 19 맵 고정
    static int map[][] = new int[20][20];

    static int win;
    static int[] point = new int[2];


    //좌 상 좌상대 우상대 우 하 좌하대 우하대
    static int dx[]={0,-1,-1,-1,0,1,1,1};

    static int dy[]={-1,0,-1,1,1,0,1,-1};

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        //맵을 입력받음.
        for(int row =1 ; row <=19;row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 1; col <=19;col++){
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for(int row = 1; row <= 19;row++){
            for(int col =1; col <= 19;col++){
                if(map[row][col] !=0){
                    //이기는 경우 일단 이기는 돌만 체크하고 끝내기 -> 더 체크할 필요없음.
                    for(int idx =0; idx <4;idx++){
                        if(simul(map[row][col],row,col,idx)){
                            System.out.println(win);
                            System.out.println(point[0] + " " + point[1]);
                            return;
                        }
                    }

                }

            }
        }
        System.out.println(0);

    }

    private static boolean simul(int color, int row, int col, int idx) {
        int count =1;

        point[0] = row;
        point[1] = col;

        int cur_row = row;
        int cur_col = col;


        //각 방향 부분 체크 진행
        while(cur_row + dx[idx] > 0 && cur_row +dx[idx] <=19 && cur_col + dy[idx] > 0 && cur_col +dy[idx] <= 19){
            int nxt_row = cur_row+dx[idx];
            int nxt_col = cur_col+dy[idx];

            if(map[nxt_row][nxt_col] == color){
                count+=1;
                cur_row+=dx[idx];
                cur_col+=dy[idx];
                
                //세로 줄인 경우
                if(point[1] == nxt_col){
                    if(point[0] > nxt_row){
                        point[0] = nxt_row;
                        point[1] = nxt_col;
                    }
                    //가로 줄 인 경우
                }else if(point[1] > nxt_col){
                    point[0] = nxt_row;
                    point[1] =nxt_col;

                }
            }
            else{
                break;
            }
        }

        //반대 방향도 체크 필요.
        int reverseIdx = (idx+4)%8;
        cur_row = row;
        cur_col = col;
        while(cur_row + dx[reverseIdx] > 0 && cur_row +dx[reverseIdx] <=19 && cur_col + dy[reverseIdx] > 0 && cur_col +dy[reverseIdx] <= 19){
            int nxt_row = cur_row+dx[reverseIdx];
            int nxt_col = cur_col+dy[reverseIdx];

            if(map[nxt_row][nxt_col] == color){
                count+=1;
                cur_row+=dx[reverseIdx];
                cur_col+=dy[reverseIdx];

                //세로 줄인 경우
                if(point[1] == nxt_col){
                    if(point[0] > nxt_row){
                        point[0] = nxt_row;
                        point[1] = nxt_col;
                    }
                    //가로 줄 인 경우
                }else if(point[1] > nxt_col){
                    point[0] = nxt_row;
                    point[1] =nxt_col;

                }
            }
            else{
                break;
            }
        }

        if(countCheck(count)){
            win = color;
            return true;
        }
        return false;

    }

    private static boolean countCheck(int count) {
        if(count == 5)
            return true;
        return false;
    }


}
