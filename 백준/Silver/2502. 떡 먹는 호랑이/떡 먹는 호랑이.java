import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(D == 3){
            System.out.println("1");
            System.out.println(K-1);
            return;
        }

        int A1[] = new int[D+1];
        int A2[] = new int[D+1];

        //계수를 적어둠.
        //A3 = A1 + A2 둘다 계수 1
        //A4 = A2 + (A3)A1+A2
        //A4 = A1 + 2*A2;


        A1[3] = A2[3] = 1;
        A1[4] = 1;
        A2[4] = 2;


        /*A5 = A4 + A3
        A5 = A1+2*A2 + A1 +A2
        A5 = 2A1 + 3A2;
        각 위치의 계수도 피보나치 수열을 이룬다.
         */
        //각 위치의 계수도 피보나치를 이룸.
        for(int idx = 5; idx <=D;idx++){
            A1[idx] = A1[idx-1] +A1[idx-2];
            A2[idx] = A2[idx-1] +A2[idx-2];
        }

        int first = 0;
        int second = 0;

        for(int idx = 1 ; ;idx++){
            int result = K - A1[D] * idx;

            if(result % A2[D] == 0){
                first = idx;
                second = result/A2[D];
                break;
            }

        }
        System.out.println(first);
        System.out.println(second);

    }
}
