class Solution {
    public int solution(int n, int[] lost, int[] reserve) 
	{
		int answer = 0;
		int[] check = new int[n];

		for (int i = 0; i < n; i++) {
			check[i] = 1;
		}

//		System.out.println("초기 = " + Arrays.toString(check));

		for (int i = 0; i < lost.length; i++) {
			check[lost[i] - 1] -= 1;
		}

//		System.out.println("도난 당한후" + Arrays.toString(check));
		for (int i = 0; i < reserve.length; i++) {
			check[reserve[i] - 1] += 1;
		}
//		System.out.println("여분 " + Arrays.toString(check));

		for (int i = 0; i < check.length; i++) {
			if (((i >= 1 && check[i] > 1)) && (check[i - 1] == 0)) {
				check[i] -= 1;
				check[i - 1]++;
			} else if (((i > 1 && check[i] > 1)) && (((i+1) < n) && check[i + 1] == 0)) {
				check[i] -= 1;
				check[i + 1]++;
			} else if (((i == 0 && check[i] > 1)) && (check[i + 1] == 0)) {
				check[i] -= 1;
				check[i + 1]++;
			}
		}
//		System.out.println("돌리기 " + Arrays.toString(check));

		for (int i = 0; i < check.length; i++) {
			if (check[i] >= 1) {
				answer++;
			}
		}

//		System.out.println(answer);

		return answer;
	}
}