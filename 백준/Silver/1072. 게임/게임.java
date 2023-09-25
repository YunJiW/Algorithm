import java.util.*;
import java.io.*;


public class Main {

    private static final int MAX_VALUE = 1000000000;

    private static int curRate;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int answer = -1;
        //둘이 같으면 변할수없음.
        if(X==Y){
            System.out.println(answer);
            return;
        }

        //현재 승률 계산
        curRate = (int)((long)100*Y/X);


        int max = MAX_VALUE;
        int min = 0;

        while(min <= max)
        {
            int mid = (max+min)/2;
            //만약 승률이 변하는 경우
            if(isChangeWinRate(X,Y,mid)){
                answer = mid;
                max = mid-1;
            }
            //승률이 변하지 않는 경우
            else{
                min = mid +1;
            }
        }

        System.out.println(answer);
    }

    //승률이 변하는 지 체크
    private static boolean isChangeWinRate(int x, int y, int mid) {
        int nxt_x = x + mid;
        int nxt_y = y + mid;

        int nxt_Rate = (int)((long)100 * nxt_y/nxt_x);

        //승률이 높아지면 변한거임.
        if(curRate < nxt_Rate){
            return true;
        }

        return false;
    }
}
