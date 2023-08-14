class Solution {
    public int solution(int[] a) {
        int answer = 0;

        int min = Integer.MAX_VALUE;
        int min_idx = 0;

        //최소값 갱신및 위치 체크
        for(int idx= 0; idx <a.length;idx++){
            if(min > a[idx]){
                min = a[idx];
                min_idx = idx;
            }
        }

        //가장 작은 수의 인덱스 기준으로 좌 체크
        //가장 끝 값은 가능하다.(존재한다면)
        int left = 0;
        int left_check = 0;
        int left_min = a[left];
        for(int index = left; index < min_idx;index++) {
            if(index == left) {
                left_check += 1;
                continue;
            }
            //왼쪽의 값보다 작은경우
            if(left_min > a[index]){
                left_check+=1;
                left_min = a[index];
            }



        }

        //가장 작은 수의 인덱스 기준으로 우 체크
        //가장 끝값은 가능함(존재한다면).
        int right = a.length-1;
        int right_check = 0;
        int right_min = a[right];
        for(int index = right; index > min_idx;index--) {
            if(index == right){
                right_check+=1;
                continue;
            }

            if(right_min > a[index]){
                right_check+=1;
                right_min = a[index];
            }



        }
        answer = left_check + right_check +1 ;

        return answer;
    }
}