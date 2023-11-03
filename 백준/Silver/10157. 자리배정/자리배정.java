import java.io.*;
import java.util.*;

public class Main {

    static int dx[] ={-1,0,1,0};
    static int dy[] ={0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int result = Integer.parseInt(br.readLine());

        int position[][] = new int[row+2][col+2];

        //불가능할경우 pass
        if(result > row * col){
            System.out.println(0);
            return;
        }

        for(int index = 0; index <=(col+1);index++){
            position[0][index] = -1;
            position[row+1][index] =-1;
        }

        for(int index = 0; index <=(row+1);index++){
            position[index][0] = -1;
            position[index][col+1] =-1;
        }



        int cur_row = row;
        int cur_col = 1;
        int value = 1;
        int dir = 0;


        while(true){
            position[cur_row][cur_col] = value;

            if(value == result){
                System.out.println(cur_col + " " + (row - cur_row +1) );
                break;
            }

            if(position[cur_row+dx[dir]][cur_col+dy[dir]] != 0){
                dir = (dir+1) % 4;
            }
            cur_row += dx[dir];
            cur_col += dy[dir];
            value+=1;

            if(value > row *col){
                break;
            }
        }

    }
}
