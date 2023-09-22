import java.io.*;

public class Main {

    static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int dp[] =new int[str.length() +1];
        dp[0] = 1;

        //각 한자리수에대한 계산
        //핵심로직
        for(int index =1; index <= str.length();index++){
            int one = str.charAt(index-1) - '0';
            if(one >= 1 && one <= 9){
                dp[index]+= dp[index-1];
                dp[index] %= MOD;
            }
            if (index == 1){
                continue;
            }
            int prev = str.charAt(index-2) - '0';

            if(prev == 0) continue;

            int value = prev*10 + one;

            if(value >= 10 && value<= 26){
                dp[index] += dp[index-2];
                dp[index] %= MOD;
            }
        }
        System.out.println(dp[str.length()]);
    }
}