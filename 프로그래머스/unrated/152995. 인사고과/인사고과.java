import java.util.*;

class Solution {
    public int solution(int[][] scores) {


        Score wanho = new Score(scores[0][0],scores[0][1],scores[0][0]+scores[0][1]);

        Arrays.sort(scores, (o1, o2) -> {
            //팀내 평가 오름차순
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }

            //근태기준내림차순
            return o2[0] - o1[0];
        });

        int maxpeer = scores[0][1];

        //인센을 못받는 사람들 먼저 체크
        for(int idx = 1;idx<scores.length;idx++){
            //최대 값보다 작은 경우
            if(scores[idx][1] < maxpeer){
                //그게 완호인 경우 -1리턴
                if(scores[idx][0] == wanho.attitude && scores[idx][1] == wanho.peer){
                    return -1;
                }

                scores[idx][0] =-1;
                scores[idx][1] =-1;
                //최대값 갱신
            }else{
                maxpeer = scores[idx][1];
            }
        }

        //합 기준 내림차순 정렬 진행
        Arrays.sort(scores,(o1,o2)-> (o2[0]+o2[1]) - (o1[0]+o1[1]));
        
        int answer = 1;

        for(int idx =0;idx<scores.length;idx++){
            if(scores[idx][0] +scores[idx][1] > wanho.sum){
                answer++;
            }else {
                break;
            }
        }

        return answer;
    }


    class Score{
        int attitude;
        int peer;

        int sum;

        public Score(int attitude,int peer,int sum){
            this.attitude =attitude;
            this.peer = peer;
            this.sum = sum;
        }
    }
}