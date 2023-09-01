class Solution {

    int answer =Integer.MAX_VALUE;

    int n, num = 0;

    int[] weak,dist,choice;

    int[][] rotateWeak;

    private boolean finish = false;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak =weak;
        this.dist =dist;
        SetWeak();

        for(int idx = 1;idx <=dist.length;idx++){
            num = idx;
            choice = new int[num];
            permutation(0,new boolean[dist.length]);
            if(finish) break;
        }

        if(finish){
            answer = num;
        }else
            answer = -1;


        return answer;
    }

    //핵심 로직 -> dist로 순열 만들기
    private void permutation(int depth, boolean[] visited) {
        if(finish) return;
        //인원선별이 끝나면 전부 보수되는지 체크
        if(depth == num){
            check();
            return;
        }

        for(int idx = 0; idx < dist.length;idx++) {
            if(!visited[idx]){
                choice[depth] = dist[idx];
                visited[idx] = true;
                permutation(depth+1,visited);
                visited[idx] = false;
            }
        }
    }

    private void check() {
        for(int[] weak : rotateWeak){
            int idx = 0, start = 0;
            boolean visit[] = new boolean[weak.length];

            while(idx != num){
                int i = start;
                int value = choice[idx++];

                for(int j = start; j <weak.length;j++){
                    if(!(weak[i] <= weak[j] && weak[j] <= weak[i] + value)) break;
                    visit[j] = true;
                    start+=1;
                }
            }
            if(isFinish(visit)){
                finish = true;
                return;
            }
        }
    }

    private boolean isFinish(boolean[] visit) {
        for (boolean bool : visit){
            if(!bool) return false;
        }
        return true;
    }

    private void SetWeak() {
        int len = weak.length;
        rotateWeak = new int[len][len];

        for(int idx = 0; idx <len;idx++){
            rotateWeak[idx] = rotate(weak,idx);
        }
    }

    //로테이션만들기 ->펼치기
    private int[] rotate(int[] weak, int idx) {
        int len = weak.length;
        int[] result = new int[len];
        for(int index = 0; index < len;index++){
            if(idx + index < len) result[index] = weak[idx+index];
            else result[index] = weak[idx+index - len] + n;
        }
        return result;
    }
}