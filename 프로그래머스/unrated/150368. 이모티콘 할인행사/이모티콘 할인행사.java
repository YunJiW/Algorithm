class Solution {

    int sale[] = {10,20,30,40};

    int size;

    int[] answer;

    int[] Combi;

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];

        answer[1] = Integer.MIN_VALUE;

        size = emoticons.length;

        Combi = new int[emoticons.length];

        Start(users,emoticons,0);
        return answer;
    }

    private void Start(int[][] users, int[] emoticons,int depth) {
        if(depth == size){
            
            //계산 시작
            int result[] = calc(users,emoticons, Combi);

            //이모티콘 플러스 가입자가 더많은 게 먼저
            if(result[0] > answer[0]){
                answer[0] = result[0];
                answer[1] = result[1];
                //가입자가 같은 경우 -> 이모티콘 판매액이 더 큰것으로 변경
            }else if(answer[0] == result[0] && result[1] > answer[1]){
                answer[0] = result[0];
                answer[1] = result[1];
            }

            return;
        }
        
        for(int idx = 0;idx <sale.length;idx++){
            Combi[depth] = sale[idx];
            Start(users,emoticons,depth+1);
        }
        
    }

    //총 계산
    private int[] calc(int[][] users, int[] emoticons, int[] combi) {

        int check[] = new int[2];


        for(int user = 0; user < users.length;user++){
            int sum = 0;

            for(int len = 0; len <emoticons.length;len++){
                //할인율이 유저가 원하는 만큼 이상인경우만
                if(combi[len] >= users[user][0]) {
                    int Calc = emoticons[len] - ((emoticons[len]/100) * combi[len]);
                    sum += Calc;
                }
            }

            //유저가 원하는 값보다 이상인경우
            if(sum >= users[user][1]){
                check[0] +=1;
                //유저가 원하는 값보다 미만인경우
            }else{
                check[1] += sum;
            }
        }

        return check;
    }
}