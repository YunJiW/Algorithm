import java.util.*;

class Solution {

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        int TableLen = timetable.length;
        List<Integer> TimeTable = new ArrayList<>();

        //분으로 변환
        for (int idx = 0; idx < TableLen; idx++) {
            String Time[] = timetable[idx].split(":");

            int sum = Integer.parseInt(Time[0]) * 60 + Integer.parseInt(Time[1]);
            TimeTable.add(sum);
        }

        //도착한 시간순 정렬
        Collections.sort(TimeTable);
        int Start = 9 * 60;

        int last_Time = 00;
        int total = 0;

        //핵심로직
        for(int idx = 0 ; idx <n;idx++){
            total = 0;
            while (!TimeTable.isEmpty()){
                int curTime = TimeTable.get(0);
                if(curTime <= Start && total < m){
                    TimeTable.remove(0);
                    total+=1;
                }else break;
                last_Time = curTime -1;
            }
            Start += t;
        }

        if(total < m) last_Time = Start - t;

        int H = last_Time / 60;
        int M = last_Time % 60;
        String HH = String.format("%02d", H);
        String MM = String.format("%02d", M);
        answer = HH + ":" + MM;

        //정답을 도출할때는 다시 "HH:MM"형식으로 변환해서 제출

        return answer;
    }
}