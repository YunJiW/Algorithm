class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;


        for (int x = 1; x <= r2; x++) {
            //정수를 구하는거기때문에 내림
            long max = (int)Math.floor(Math.sqrt(1.0*r2 * r2 - 1.0*x * x));
            long min = 0;
            if (x >= r1) {
                min = 0;
            } else {
                //정수기 때문에 올림
                min = (int) Math.ceil(Math.sqrt(1.0*r1 * r1 - 1.0*x * x));
            }


            answer += max - min + 1;
        }


        // 원의 1사분면만 구한거기때문에 *4 진행
        return answer *4 ;
    }
}