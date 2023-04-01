import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        //절댓값 기준으로 우선순위 정렬 
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //둘의 절댓값이 같으면 숫자를 비교해서 오름차순 정렬
                if(Math.abs(o1) == Math.abs(o2))
                {
                    return o1 - o2;
                    //그외는 절댓값 기준 정렬
                }else
                {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test= 0; test< T;test++){
            int number = Integer.parseInt(br.readLine());
            //값이 0이 입력된경우 가장 작은 수를 출력하고 다음 값으로 이동 or 큐에 없는 경우 0 실어주고 다음값으로
            if(number == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.offer(number);
            }
        }

        System.out.println(sb);
    }
}
