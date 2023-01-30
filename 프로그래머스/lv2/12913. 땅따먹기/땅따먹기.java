class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int prefix[][] = new int[land.length][4];

        prefix[0][0] = land[0][0];
        prefix[0][1] = land[0][1];
        prefix[0][2] = land[0][2];
        prefix[0][3] = land[0][3];

        for(int index = 1 ; index <land.length;index++)
        {
            prefix[index][0] = Math.max(prefix[index-1][1],Math.max(prefix[index-1][2],prefix[index-1][3])) + land[index][0];
            prefix[index][1] = Math.max(prefix[index-1][0],Math.max(prefix[index-1][2],prefix[index-1][3])) + land[index][1];
            prefix[index][2] = Math.max(prefix[index-1][0],Math.max(prefix[index-1][1],prefix[index-1][3])) +land[index][2];
            prefix[index][3] = Math.max(prefix[index-1][0],Math.max(prefix[index-1][1],prefix[index-1][2])) +land[index][3];


        }

        int len = prefix.length-1;
        answer = Math.max(prefix[len][0],Math.max(prefix[len][1],Math.max(prefix[len][2],prefix[len][3])));

        return  answer;
    }
}