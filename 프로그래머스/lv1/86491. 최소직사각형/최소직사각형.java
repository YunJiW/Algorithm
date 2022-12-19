class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        //둘중 큰값을 한쪽에 몰아놓기
        for(int width=0;width<sizes.length;width++)
        {
            int temp = 0;
            if(sizes[width][0] < sizes[width][1])
            {
                temp = sizes[width][0];
                sizes[width][0] = sizes[width][1];
                sizes[width][1] = temp;
            }
        }
        int widths_Max =Integer.MIN_VALUE;
        int heights_Max=Integer.MIN_VALUE;
        
        for(int num=0;num<sizes.length;num++)
        {
            widths_Max = Math.max(widths_Max,sizes[num][0]);
            heights_Max =Math.max(heights_Max,sizes[num][1]);
        }
        
        answer = widths_Max * heights_Max;
        
        
        
        return answer;
    }
}