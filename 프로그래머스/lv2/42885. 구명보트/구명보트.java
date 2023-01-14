import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //정렬
        Arrays.sort(people);
        
        //구명보트 인원수
        int boat_in = 0;
        //구명보트에 탄 사람들의 무게
        int weight = 0;
        int idx = 0;
        int index =0;
        for(index = people.length-1; index >=0; index--){
            weight = people[index];

            if(index == idx)
            {
                answer+=1;
                break;
            }
            if(index <idx)
            {
                break;
            }
            if(people[idx] + weight > limit)
            {
                answer+=1;
            }else{
                answer+=1;
                idx++;
            }
            
        }
        
        return answer;
    }
}