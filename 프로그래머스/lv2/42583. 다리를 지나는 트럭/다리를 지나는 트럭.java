import java.util.LinkedList;
import java.util.Queue;



class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int answer = 0;


        int time =0;
        int cur_weight=0;

        for(int index = 0; index <truck_weights.length;index++){
            int truck = truck_weights[index];

            while(true){
                //아직 다리에 아무것도 안올라갔을 경우
                if(bridge.isEmpty()){
                    bridge.offer(truck);
                    cur_weight += truck;
                    time+=1;
                    break;
                    //다리가 꽉차있을경우
                } else if(bridge.size() == bridge_length){
                    cur_weight -= bridge.poll();
                    //다리에 올라가있을경우
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
        return time + bridge_length;
    }
}