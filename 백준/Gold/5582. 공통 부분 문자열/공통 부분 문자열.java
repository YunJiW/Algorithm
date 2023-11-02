import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        //값체크용
        int result = 0;

        int dp[][] = new int[s.length()+1][t.length()+1];

        for(int row =1 ;row <=s.length();row++){
            for(int col =1 ;col<=t.length();col++){
                if(s.charAt(row-1) == t.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1] +1;
                    result = Math.max(result,dp[row][col]);
                }
            }
        }

        System.out.println(result);

    }
}
