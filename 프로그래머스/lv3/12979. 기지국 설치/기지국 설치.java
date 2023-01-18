class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        //w 전파가능 거리
        //n 전체 거리

        int start_range= 0;
        int end_range=0;

        //자신 과 양쪽 거리
        int w_range = 1+(w*2);
        //첫번째 구역 왼쪽부분
        if(stations[0] - w > 0){
            int first_range = stations[0] -w-1;
            answer += first_range / w_range;
            if(first_range % w_range != 0){
                answer+=1;
            }
        }

        //중앙부분
        for(int index = 1; index <stations.length;index++){
            start_range = stations[index-1] + w+1;
            end_range = stations[index] -w-1;

            if(end_range-start_range +1 > 0){

             answer+= (end_range-start_range +1)/w_range;
                if((end_range-start_range +1)%w_range != 0)
                {
                    answer+=1;
                 }
            }
        }

        //마지막 구역 오른쪽 부분
        if(stations[stations.length-1] + w < n){
            int last_range = stations[stations.length-1] +w + 1;
            answer += (n - last_range +1)/w_range;
            if((n-last_range+1)%w_range != 0){
                answer+=1;
            }
        }



        return answer;
    }
}