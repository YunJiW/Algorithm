import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int TC = 0; TC < T;TC++){
            int N  = Integer.parseInt(br.readLine());
            int number[] = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx <N;idx++){
                number[idx] = Integer.parseInt(st.nextToken());
            }

            //크기 순정렬 진행
            Arrays.sort(number);
            int left = N -1;
            int right = 0;

            int SelectNum[] = new int[N];

            for(int idx = 0; idx < N;idx++) {
                if (idx % 2 == 0) {
                    SelectNum[left--] = number[idx];
                } else {
                    SelectNum[right++] = number[idx];
                }
            }

            int result = Integer.MIN_VALUE;
            for(int idx = 1; idx <N;idx++){
                result = Math.max(result,Math.abs(SelectNum[idx] - SelectNum[idx-1]));
            }
            result =Math.max(result,Math.abs(SelectNum[0] - SelectNum[N-1]));


            sb.append(result).append("\n");
        }

        System.out.print(sb);

    }
}