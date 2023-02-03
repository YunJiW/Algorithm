
import java.util.Stack;


class Solution 
{
	public int solution(int[] order) {
		int answer = 0;

		Stack<Integer> container = new Stack<>();

		Stack<Integer> sub_container = new Stack<>();
		for (int index = order.length; index > 0; index--) {
			container.push(index);
		}
		boolean check = true;

		for (int index = 0; index < order.length; index++) {

			if (!check) {
				break;
			}
			// 컨테이너가 비어있지않다면 -> 서브컨테이너로 전부 옮기거나 다 뽑지 않은경우
			if (!container.isEmpty()) {
				while (!container.isEmpty()) {
					// 컨테이너의 맨위의 있는 택배와 오더와 같을경우 꺼내고 answer+=1
					if (container.peek() == order[index]) {
						container.pop();
						answer += 1;
						break;
					}
					// 컨테이너의 맨위의 값이 오더보다 작을경우 서브컨테이너로 옮김
					if (container.peek() < order[index]) {
						sub_container.push(container.pop());
						continue;
					}
					if (container.peek() > order[index]) {
						if (sub_container.peek() == order[index]) {
							sub_container.pop();
							answer += 1;
							break;
						}
						if (sub_container.peek() != order[index]) {
							check = false;
							break;
						}
					}
				}
			}
			// 컨테이너가 다비어서 서브컨테이너 또는 전부 빠진경우
			else {
				if (!sub_container.isEmpty() && sub_container.peek() == order[index]) {
					sub_container.pop();
					answer += 1;
				} else {
					break;
				}
			}

		}
		return answer;
	}
}