import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        long[] plusdp = new long[sequence.length];
        long[] minusdp = new long[sequence.length];

        plusdp[0] = sequence[0];
        minusdp[0] = sequence[0] * -1;


        for(int idx = 1; idx <sequence.length;idx++){
            long num = sequence[idx];

            if(idx %2 == 1){
                plusdp[idx] = Math.max(plusdp[idx-1]+num*-1,num*-1);
                minusdp[idx] = Math.max(minusdp[idx-1]+num,num);
            }else{
                plusdp[idx] = Math.max(plusdp[idx-1]+num,num);
                minusdp[idx] = Math.max(minusdp[idx-1]+num*-1,num*-1);
            }

        }

        Arrays.sort(plusdp);
        Arrays.sort(minusdp);

        answer = Math.max(plusdp[sequence.length-1],minusdp[sequence.length-1]);
        return answer;
    }
}