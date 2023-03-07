class Solution {
    public String solution(String number, int k) {
        StringBuilder ans = new StringBuilder();
        int len = number.length() - k; // 자리수
        int start = 0;
        while(start < number.length() && ans.length() != len){
            int leftNum = k + ans.length() + 1;
            int max = 0;
            //
            for(int idx = start; idx < leftNum;idx++){
                if(max < number.charAt(idx) -'0'){
                    max = number.charAt(idx) -'0';
                    start = idx +1;
                }
            }
            ans.append(Integer.toString(max));
        }
        return ans.toString();
    }
}