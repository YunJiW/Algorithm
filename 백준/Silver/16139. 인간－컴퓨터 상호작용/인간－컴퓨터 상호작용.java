import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문제에 주어지는 라인
        String line = br.readLine();

        int T = Integer.parseInt(br.readLine());

        int sum[][] = new int[line.length()][26];

        sum[0][line.charAt(0) - 'a' -'\0'] +=1;
        for(int idx = 1; idx < line.length();idx++){
            //전값을 가져옴.
            for(int alpa = 0; alpa<26;alpa++){
                sum[idx][alpa] = sum[idx-1][alpa];
            }
            char cur = line.charAt(idx);
            int curIdx= cur - 'a' -'\0';
            sum[idx][curIdx] +=1;

        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int TC = 0; TC < T; TC++){
            st = new StringTokenizer(br.readLine());
            char[] ch = st.nextToken().toCharArray();
            int first = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int select = ch[0] - 'a' -'\0';

            if(first != 0) {
                sb.append(sum[end][select] - sum[first - 1][select]).append("\n");
            }
            else{
                sb.append(sum[end][select]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
