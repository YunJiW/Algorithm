import java.util.HashMap;
class Solution
{
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		HashMap<String, Integer> map = new HashMap<>();

		// HashMap으로 매칭 시켜둠.
		for (int index = 0; index < want.length; index++) {
			map.put(want[index], number[index]);
		}

		for (int index = 0; index < discount.length; index++) {
			//10일이 안될경우 break;
			if (index + 9 >= discount.length)
				break;
			
			
			if (!map.containsKey(discount[index]))
				continue;

			// 체크용 hashMap
			HashMap<String, Integer> checking_count = new HashMap<>();

			boolean checking = true;


			for (int days = index; days <= index + 9; days++) {
				// 내가 필요한 제품이 아닐경우 이날은 아니기 떄문에 끝내줌.
				if (!map.containsKey(discount[days])) {
					break;
				} else {
					checking_count.put(discount[days], checking_count.getOrDefault(discount[days], 0) + 1);
				}
			}
			if (checking_count.isEmpty())
				continue;

			// 필요한 제품의 개수가 하나라도 틀릴경우 checking = false가 됨.
			for (String apples : map.keySet()) {
				if (map.get(apples) != checking_count.get(apples)) {
					checking = false;
					break;
				}
			}
			if (checking) {
				answer += 1;
			}
		}

		return answer;
	}
}