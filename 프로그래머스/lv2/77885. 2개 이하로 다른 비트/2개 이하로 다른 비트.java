class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int idx = 0; idx <numbers.length;idx++){
            //시작 값
            long start_num = numbers[idx];

            //짝수
            if(start_num %2 == 0){
                answer[idx] = start_num+1;
                //홀수
            }else{
                String num_bit = Long.toBinaryString(start_num);
                int zeroIdx = num_bit.lastIndexOf("0");
                //홀수를 2진변환시 0이 존재하는경우
                if(zeroIdx != -1){
                    num_bit = num_bit.substring(0,zeroIdx)+"10"+ num_bit.substring(zeroIdx+2,num_bit.length());
                    //0이없는 홀수의 경우
                }else{
                    num_bit = "10" + num_bit.substring(1,num_bit.length());
                }
                answer[idx] = Long.parseLong(num_bit,2);

            }
        }
        return answer;
    }

}