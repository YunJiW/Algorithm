class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        for(int idx=0; idx<arr.length;idx++){
            answer+= arr[idx];
        }
        answer /= arr.length;
        return answer;
    }
}