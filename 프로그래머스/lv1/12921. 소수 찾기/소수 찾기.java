class Solution {
    static int prime[] = new int[1000001];
    public int solution(int n) {
        int answer = 0;
        isprime_check();
        for(int idx =2; idx <= n;idx++){
            if(prime[idx] == 0)
                answer+=1;
        }
        return answer;
    }

    private void isprime_check() {
        prime[0] = prime[1] = 1;
        for(int idx = 2; idx <=Math.sqrt(1000000); idx++){
            if(prime[idx] == 1) continue;
            for(int checking=idx*2;checking <=1000000;checking+=idx){
                prime[checking] = 1;
            }
        }
    }


}
