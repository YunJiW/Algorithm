import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean visited[];


    class Alpha{
        String str;
        int idx;

        Alpha(String str,int idx){
            this.str= str;
            this.idx = idx;
        }
        public String getstr(){
            return str;
        }
        public int getidx(){
            return idx;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];


        answer = Run(begin,target,words);


        return answer;
    }

    public int Run(String begin, String target, String[] words){
        Queue<Alpha> que = new LinkedList<>();

        que.offer(new Alpha(begin,0));
        while(!que.isEmpty()){
            Alpha val = que.poll();

            if(check(val.getstr(),target)){
                return val.getidx();
            }

            for(int index = 0;index <words.length;index++){
                //아직 방문하지않은 단어이면서 변화가 가능할경우 변화
                if(!visited[index] && ispossible(val.getstr(),words[index])){
                    visited[index] = true;
                    que.offer(new Alpha(words[index],val.getidx()+1));
                }
            }


        }

        //없을경우
        return 0;
    }
    public boolean ispossible(String cur_str,String nxt_str){
        int cnt = 0;
        for(int index = 0;index <cur_str.length();index++){
            if(cur_str.charAt(index) != nxt_str.charAt(index)){
                cnt++;
            }

            //1개이상 차이날경우 바꿀수없음
            if(cnt > 1){
                return false;
            }
        }



        return true;
    }
    
    //타겟과 아예 같아야함.
    public boolean check(String cur_str,String target){
        for(int index = 0;index <target.length();index++){
            if(cur_str.charAt(index) != target.charAt(index)){
                return false;
            }

        }



        return true;
    }

}