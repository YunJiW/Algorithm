class Solution {
    public int solution(int n) {
        int answer = 0;

        String encord = Integer.toString(n,3);
        StringBuilder sb = new StringBuilder(encord);
        encord = sb.reverse().toString();

        answer = Integer.parseInt(encord,3);

        return answer;
    }
}
