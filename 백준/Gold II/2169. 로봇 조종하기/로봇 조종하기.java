import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int map[][] =new int[n+1][m+1];
        int dp[][] = new int[n+1][m+1];
        int tmp[][] = new int[2][m+2];

        for(int row =1;row <=n;row++)
        {
            st = new StringTokenizer(br.readLine());
            for(int col = 1; col<=m;col++){
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        //시작
        dp[1][1] = map[1][1];

        //첫줄값 계산 -> 어쩌피 시작은 1,1이기때문에
        for(int idx = 2; idx <=m;idx++){
            dp[1][idx] = dp[1][idx-1]+map[1][idx];
        }

        //둘째줄부터 시작
        for(int row = 2; row <=n;row++){
            tmp[0][0] = dp[row-1][1];
            
            //왼쪽 -> 오른쪽갈때 위값과 왼쪽값 중 큰값으로 정하기
            for(int col = 1; col <=m;col++){
                tmp[0][col] = Math.max(tmp[0][col-1],dp[row-1][col]) + map[row][col];
            }
            tmp[1][m+1] = dp[row-1][m];

            //오른쪽 -> 왼쪽 되는겨웅 위쪽과 오른쪽에서 오는 값중 큰값 정하기
            for(int col = m; col >=1; col--){
                tmp[1][col] = Math.max(tmp[1][col+1],dp[row-1][col]) + map[row][col];
            }

            //둘중 최대값이 dp에 저장됨.
            for(int col = 1; col <=m;col++){
                dp[row][col] = Math.max(tmp[0][col],tmp[1][col]);
            }
        }
        System.out.println(dp[n][m]);

    }
}
