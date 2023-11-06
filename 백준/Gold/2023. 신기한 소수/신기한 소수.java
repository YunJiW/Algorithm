import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        dfs(0,N);


        System.out.print(sb);

    }

    private static void dfs(int num,int index) {
        if(index == 0){
            sb.append(num).append("\n");
        }
        for(int idx =1; idx <10;idx++){
            int tmp = 10*num + idx;
            if(index > 0 && isPrime(tmp)){
                dfs(tmp,index-1);
            }
        }
    }


    //소수 체크
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int idx = 2; idx *idx <= num ;idx++){
            if(num % idx ==0){
                return false;
            }
        }

        return true;
    }
}
