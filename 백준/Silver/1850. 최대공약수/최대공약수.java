import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        //크기가 B가 더큰경우 둘의 위치를 바꾼다.
        if(A < B){
            long temp = A;
            A = B;
            B = temp;
        }
        long result = gcd(A,B);
        StringBuilder sb = new StringBuilder();
        for(int idx = 1; idx <=result;idx++){
            sb.append("1");
        }
        System.out.println(sb);


    }

    private static long gcd(long a, long b) {
        while(b > 0){
            long temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }
}
