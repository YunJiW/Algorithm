import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0;i<10;i++)
            arr.add(i);
        
        Arrays.sort(numbers);
        
        for(int i=0;i<numbers.length;i++){
            arr.remove(Integer.valueOf(numbers[i]));
        }
        
        for(int i : arr)
            answer +=i;
        return answer;
    }
}