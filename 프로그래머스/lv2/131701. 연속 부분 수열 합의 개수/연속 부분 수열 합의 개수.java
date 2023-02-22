import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        
        HashSet<Integer> sum_all = new HashSet<>();
        //1개부터 개수만큼 계속 체크
        for(int idx=1;idx<=elements.length;idx++){
            for(int start=0; start < elements.length;start++){
                int sum =0;
                for(int select=start; select <start+idx;select++){
                    sum+= elements[select % len];
                }
                sum_all.add(sum);
            }
            
        }
        return sum_all.size();
    }
}