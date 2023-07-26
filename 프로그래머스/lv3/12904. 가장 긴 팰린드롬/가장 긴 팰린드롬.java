class Solution
{
    public int solution(String s)
    {
        int max_len = Integer.MIN_VALUE;

            for (int idx = 0; idx < s.length(); idx++) {
                max_len = Math.max(max_len, odd_palim(s, idx));
                max_len = Math.max(max_len,even_palim(s,idx));
            }


        return max_len;
    }

    private int even_palim(String s, int idx) {
        int cnt = 0;
        if(idx == 0 || idx ==s.length()-1)
            return cnt;

        int left = idx;
        int right = idx+1;
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left-=1;
                right+=1;
                cnt+=2;
            }else{
                break;
            }
        }

        return cnt;

    }

    //팰린드롬 체크
    private int odd_palim(String s, int idx) {
        int cnt = 1;
        if(idx == 0 || idx ==s.length()-1){
            return cnt;
        }

        int left = idx -1;
        int right = idx+1;
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left-=1;
                right+=1;
                cnt+=2;
            }else{
                break;
            }
        }

        return cnt;
    }
}