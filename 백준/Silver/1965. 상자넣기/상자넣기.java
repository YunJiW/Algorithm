import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //총 개수
        int N = Integer.parseInt(br.readLine());

        int number[] = new int[N];
        int dp[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());


        //숫자 넣어두기
        for(int idx = 0;idx < N;idx++){
            number[idx] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;

        for(int index = 0; index <N;index++){
            dp[index] = 1;
            for(int before = 0; before <index;before++){
                if(number[index] > number[before]){
                    dp[index] = Math.max(dp[before]+1,dp[index]);
                }
            }
            result = Math.max(result,dp[index]);
        }

        System.out.println(result);


    }
}
