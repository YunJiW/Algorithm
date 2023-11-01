import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc < T; tc++){
            int day = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int stock[] = new int[day];

            long result = 0;
            for(int index = 0; index <day;index++){
                stock[index] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            for(int index = day-1; index >= 0;index--){
                if(max <= stock[index]){
                    max = stock[index];
                }else{
                    result += max - stock[index];
                }
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
