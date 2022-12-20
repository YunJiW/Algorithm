class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int index =0; index <n;index++)
        {
            answer[index] ="";
            String map1_by = Integer.toBinaryString(arr1[index]);
            String map2_by = Integer.toBinaryString(arr2[index]);
            
            //둘을 2진변환해서 길이를 체크
            int map1_len = map1_by.length();
            int map2_len = map2_by.length();
            
            //길이가 n보다 짧을 경우 0을 추가해준다.
            if(map1_len < n)
            {
                for(int lens = n - map1_len; lens > 0;lens--)
                {
                    map1_by= "0" + map1_by;
                }
            }
            
            if(map2_len < n)
            {
                for(int lens = n - map2_len; lens > 0;lens--)
                {
                    map2_by= "0" + map2_by;
                }
            }
            
            
            for(int check=0;check < n;check++)
            {
                if(map1_by.charAt(check) == '1' || map2_by.charAt(check) == '1')
                {
                    answer[index] +="#";
                }
                else{
                    answer[index] +=" ";
                }
            }
        }
        
        
        return answer;
    }
}