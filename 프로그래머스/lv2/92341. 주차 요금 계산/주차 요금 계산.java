import java.util.*;

class Solution {
    //마지막에 나가지않을경우 계산을 위한 12:00를 분으로 환산
    int max_min = 1439;
    public int[] solution(int[] fees, String[] records) {

        //차량번호와
        //key : 차량번호 , value : 시간
        HashMap<String,Integer> car_checking = new HashMap<>();
        //key :차량번호, value :주차요금
        HashMap<String,Integer> car_fee = new HashMap<>();
        for(int idx = 0; idx < records.length;idx++){
            //받은 값들을 분/차량번호/ in/out 분리
            String[] part = records[idx].split(" ");
            //분을 구하기위한 분리
            String[] time = part[0].split(":");
            int min = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            //입차시 차량번호와 시간 저장
            if(part[2].equals("IN")){
                car_checking.put(part[1],min);
                //Out일경우 출차의 경우 누적시간체크
            }else{
                int diff = min - car_checking.get(part[1]);
                car_fee.put(part[1],car_fee.getOrDefault(part[1],0) + diff);
                car_checking.remove(part[1]);
            }
        }
        //남아있을경우 -> 12:59분에 출차했다고 가정
        if(!car_checking.isEmpty()){
            for(String key : car_checking.keySet()){
                int diffs = max_min - car_checking.get(key);
                car_fee.put(key,car_fee.getOrDefault(key,0) + diffs);
            }
        }
        //key값 정렬하고 값을 계산해서 넣어준다.
        List<String> keySet = new ArrayList<>(car_fee.keySet());
        Collections.sort(keySet);
        int[] answer = new int[keySet.size()];
        for(int idx = 0; idx < keySet.size();idx++)
        {
            int number =  car_fee.get(keySet.get(idx)) - fees[0] ;
            if(number < 0){
                answer[idx] = fees[1];
            }else{
                answer[idx] = fees[1] +(int)Math.ceil((double)number/(double)fees[2]) *fees[3];
            }
        }

        return answer;
    }

}