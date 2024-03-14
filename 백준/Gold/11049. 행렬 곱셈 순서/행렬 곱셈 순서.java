import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        int matrix[][] = new int[N][2];
        int dp[][] = new int[N][N];

        for(int idx =0; idx <N; idx++){
            st= new StringTokenizer(br.readLine());
            matrix[idx][0] = Integer.parseInt(st.nextToken());
            matrix[idx][1] = Integer.parseInt(st.nextToken());
        }

        //초기화
        for(int row = 0; row <N;row++){
            for(int col = 0 ; col < N;col++){
                dp[row][col] = Integer.MAX_VALUE;
            }
        }

        //핵심로직
        for(int row=0; row < N; row++){
            for(int col = 0; col<N - row ; col++){
                int  a = col;
                int b = col+row;
                if(a == b) dp[a][b] = 0;
                else{
                    for(int k = a; k < b;k++){
                        dp[a][b] = Math.min(dp[a][b],dp[a][k] +dp[k+1][b] + matrix[a][0] * matrix[k][1] * matrix[b][1]);
                    }
                }

            }
        }
        System.out.println(dp[0][N-1]);
    }
}

