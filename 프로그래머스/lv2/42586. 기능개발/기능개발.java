import java.util.LinkedList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        
        int time[] = new int[progresses.length];
        for(int index = 0; index < progresses.length;index++){
            int days = (100 - progresses[index])/speeds[index];
            if((100 - progresses[index])%speeds[index] != 0){
                days+=1;
            }
            time[index] = days;
        }
        //7 3 9
                
        LinkedList<Integer> returns = new LinkedList<>();
        int publish = time[0];
        int count = 1;
        for(int index =1; index <time.length;index++){
            if(publish >= time[index]){
                count+=1;
            }
            else{
                returns.offer(count);
                count=1;
                publish = time[index];
            }
        }
        returns.offer(count);
        int answer[] = new int[returns.size()];
        for(int index = 0;index < returns.size();index++){
            answer[index] =returns.get(index);
        }
        
        return answer;
    }
}