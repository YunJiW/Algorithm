class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(int idx = 0; idx <=d;idx+=k){
            int Maxy= Distance(idx,d);

            answer += (Maxy/k)+1;
        }


        return answer;
    }

    private int Distance(int idx, int d) {
        long x = (long) Math.pow(idx,2);
        long dd =(long) Math.pow(d,2);

        int result = (int)(Math.sqrt(dd-x));
        return result;
    }
}