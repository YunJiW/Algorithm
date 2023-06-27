import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {

        int Time[][] = new int[book_time.length][2];

        //입 퇴실시간 분으로 전체 변환
        for (int idx = 0; idx < book_time.length; idx++) {
            //입실시간
            String[] time = book_time[idx][0].split(":");
            Time[idx][0] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            //퇴실시간
            time = book_time[idx][1].split(":");
            Time[idx][1] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) + 10;

        }

        //입실 시간 기준 정렬
        Arrays.sort(Time, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for(int[] times : Time){
            if(rooms.isEmpty()){
                rooms.offer(times[1]);
                continue;
            }

            int earlistEmptyRoom = rooms.peek();
            if(times[0] >=earlistEmptyRoom){
                rooms.poll();
                rooms.offer(times[1]);
            }else {
                rooms.offer(times[1]);
            }
        }


        return rooms.size();
    }
}