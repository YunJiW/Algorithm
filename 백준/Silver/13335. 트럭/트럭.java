import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        int[] truck_weight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            truck_weight[idx] = Integer.parseInt(st.nextToken());
        }

        int result = Start(width,weight,truck_weight);

        System.out.println(result);
    }

    private static int Start(int len, int weight, int[] truckWeight) {
        Queue<Integer> bridge = new LinkedList<>();

        int time = 0;
        int cur_weight= 0;

        for(int idx= 0; idx <truckWeight.length;idx++){
            int truck = truckWeight[idx];

            while(true){
                if(bridge.isEmpty()){
                    bridge.offer(truck);
                    cur_weight+=truck;
                    time+=1;
                    break;
                }else if(bridge.size() == len){
                    cur_weight-= bridge.poll();
                }else{
                    if(cur_weight + truck <= weight){
                        bridge.offer(truck);
                        cur_weight+= truck;
                        time+=1;
                        break;
                    }else{
                        bridge.offer(0);
                        time+=1;
                    }
                }

            }

        }
        return time + len;
    }
}
