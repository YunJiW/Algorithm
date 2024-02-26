import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T;tc++){
            int size = Integer.parseInt(br.readLine());
            //중앙값은 총사이즈/2 개까지 나옴. -> 홀수라고 명시햇기 때문에.
            sb.append((size+1)/2).append("\n");

            Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> maxHeap = new PriorityQueue<>();


            int cnt = 0;
            for(int idx = 0; idx <size;idx++){
                //10개씩 숫자가 주어지기 때문에 필요.
                if(idx %10 == 0)
                    st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());

                if(minHeap.size() == maxHeap.size())
                    maxHeap.offer(num);
                else{
                    minHeap.offer(num);
                }

                if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                    if(minHeap.peek() > maxHeap.peek()){
                        int tmp = maxHeap.poll();
                        maxHeap.offer(minHeap.poll());
                        minHeap.offer(tmp);
                    }
                }

                if(idx%2 == 0){
                    sb.append(maxHeap.peek());
                    sb.append(" ");

                    cnt+=1;

                    if(cnt % 10 == 0 )
                        sb.append("\n");
                }
            }


            sb.append("\n");
        }
        System.out.println(sb);
    }
}
