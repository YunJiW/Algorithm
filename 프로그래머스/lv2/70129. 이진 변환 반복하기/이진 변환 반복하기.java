class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int convert_cnt=0;
        int cnt = 0;
        //1일때까지 계속 변환
        while(!s.equals("1")){
            //0을 제거하고 받아둘 배열
            String convert="";
            for(int index =0 ;index < s.length();index++)
            {
                if(s.charAt(index) == '0')
                {
                    cnt +=1;
                }else
                    convert+=String.valueOf(s.charAt(index));
            }
            int len = convert.length();
            s = Integer.toBinaryString(len);
            convert_cnt +=1;
        }
        
        answer[0] = convert_cnt;
        answer[1] = cnt;
        return answer;
    }
}