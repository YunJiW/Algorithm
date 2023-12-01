import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //오름차순 정리
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //역순 정리
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        StringBuilder sb = new StringBuilder();

        for(int idx = 0; idx < n; idx++){
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size())
                maxHeap.offer(num);
            else
                minHeap.offer(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                if(minHeap.peek() < maxHeap.peek()){
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }
            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb);
    }
}