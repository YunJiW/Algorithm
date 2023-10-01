import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int First = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int idx =1; idx < N;idx++){
            int ring = Integer.parseInt(st.nextToken());

            int GCD = getGCD(First,ring);
            int LCM = getLCM(First,ring,GCD);
            sb.append(LCM/ring).append("/").append(LCM/First).append("\n");
        }
        System.out.print(sb);
    }

    public static int getGCD(int num1,int num2){
        if(num1 % num2 == 0 ){
            return num2;
        }
        return getGCD(num2,num1%num2);
    }

    public static int getLCM(int num1,int num2,int gcd){
        return (num1*num2)/gcd;
    }
}
