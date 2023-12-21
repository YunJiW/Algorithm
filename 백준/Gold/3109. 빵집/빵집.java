import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static int R;
    static int C;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        //현재 나온 맵 받아두기
        for(int row = 0; row <R;row++)
        {
            String line = br.readLine();
            for(int col = 0; col <C;col++){
                map[row][col] = line.charAt(col);
            }
        }

        for(int row = 0; row < R; row++){
            if(check(row,0))
                result+=1;
        }

        System.out.println(result);



    }

    public static boolean check(int row,int col){
        map[row][col] = '-';

        if(col == C-1){
            return true;
        }

        //오른쪽 위
        if(row > 0 && map[row-1][col+1] == '.'){
            if(check(row-1,col+1))
                return true;
        }
        //오른쪽
        if(map[row][col+1] == '.'){
            if(check(row,col+1))
                return true;
        }


        //오른쪽 아래
        if(row+1 < R && map[row+1][col+1] == '.'){
            if(check(row+1,col+1))
                return true;
        }

        return false;
    }
}
