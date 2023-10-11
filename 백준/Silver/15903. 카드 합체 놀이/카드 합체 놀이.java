import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> list = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        long result = 0;
        
        //우선순위큐에 넣어두기
        for(int idx = 0; idx < N;idx++){
             list.offer(Long.parseLong(st.nextToken()));
        }

        for(int idx = 0; idx < M ;idx++){
            long first = list.poll();
            long second = list.poll();

            long sum = first+second;

            list.offer(sum);
            list.offer(sum);
        }

        while(!list.isEmpty()){
            result += list.poll();
        }

        System.out.println(result);

    }
}
