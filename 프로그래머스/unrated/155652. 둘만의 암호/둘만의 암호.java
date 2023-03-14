//skip에있는 단어는 포함하면안됨
// a~ z 26 개
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        //스킵문자 체크용 true는 못쓰는거
        boolean skips[] = new boolean[26];
        for(int idx = 0; idx < skip.length();idx++){
            char alpa = skip.charAt(idx);
            skips[alpa - 'a'] = true;
        }
        for(int start = 0; start < s.length();start++){
            char alpas = s.charAt(start);
            int check = 0;
            //index 크기까지 계속 이동
            while(check < index){
                //아닌경우 check를 +1을해준다
                alpas = (char) ('a'+(char)((alpas +1-'a')% 26));
                int alpa_check = alpas -'a';
                if(!skips[alpa_check]){
                    check+=1;
                }
            }
            answer+= alpas;

        }
        return answer;
    }
}