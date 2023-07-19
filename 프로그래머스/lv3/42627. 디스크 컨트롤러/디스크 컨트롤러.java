import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        int end = 0;
        int jobsIdx = 0;
        int count = 0;


        //요청 시간순 정렬(무조건 적으로 요청시간기준으로 준다는 말이 없으니까)
        Arrays.sort(jobs, new Comparator<int[]>() {

            public int compare(int o1[], int o2[]) {
                //요청시간이 같은경우 소요시간기준 오름차순 정렬
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }

        });
        //소요시간순정렬 (우선순위 큐 이용)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        //핵심 로직(생각 못한거)
        while(count < jobs.length){

            //하나의 작업이 완료되는 시점까지 들어온 모든 요청을 큐에 넣는다.
            //지속적으로 걸리는 부분 넣어주는 역할
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end){
                pq.offer(jobs[jobsIdx++]);
            }

            //큐가 비어있다면 작업완료 이후에 다시 요청 들어옴.
            if(pq.isEmpty()){
                end = jobs[jobsIdx][0];
            }else{
                int[] temp = pq.poll();
                answer+= temp[1] + end - temp[0];
                end+= temp[1];
                count++;
            }

        }

        //나눈 값 리턴해줌.(소수 이하 버림.)
        return (int)Math.floor(answer/jobs.length);
    }

}