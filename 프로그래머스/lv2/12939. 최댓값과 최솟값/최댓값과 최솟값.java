class Solution {
    public String solution(String s) {
        
        String[] numbers = s.split(" ");
        int num[] = new int[numbers.length];
        int Max =Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;
        for(int index = 0; index <numbers.length;index++)
        {
            num[index] = Integer.parseInt(numbers[index]);
        }
        for(int index = 0; index <num.length;index++)
        {
            Max = Math.max(Max,num[index]);
            Min = Math.min(Min,num[index]);
        }
        
        String answer = String.valueOf(Min) + " " + String.valueOf(Max);
        return answer;
    }
}