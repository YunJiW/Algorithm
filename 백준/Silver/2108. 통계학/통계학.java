//통계학

// 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값. 소수점 이하 첫째자리에서 반올림한 값 출력
// 2. 중앙값 : N개의 수들중 증가하는 순서로 나타냈을 경우 그 중앙에 위치하는 값
// 3. 최빈값 : 가장 많이 있는수. 단 여러개가 있을경우 최빈값 중 두번째로 작은 값을 출력
// 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이

//정수 범위 -4000 ~ 4000; -> 0 ~ 8000때리고 숫자 다세고 거기서 -4000을때려버리면 같지않을까?

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		double sum =0;
		int avg;
		
		//값을 받아두면서 산술평균 계산
		for(int i = 0 ;i<N;i++)
		{
			arr[i] = 4000 + Integer.parseInt(br.readLine());
			sum += arr[i] - 4000;
		}
		avg = (int)Math.round((sum/arr.length));
		sb.append(avg).append("\n");
		
		//중앙값 및 범위안의 최대 최소 차이계산을 위한 정렬
		Arrays.sort(arr);
		
		//중앙값
		int mid = arr[arr.length/2] - 4000;
		sb.append(mid).append("\n");
		
		//최빈값
		
		//최빈값의 크기 확인 -> 최빈값인 수가 여러개 있는가? yes : 그중 2번째 작은값 찾기 no:그냥 찍음.
		int[] cnt = new int[arr[arr.length-1]+1];
		int frequency = 0;
		int frequency_cnt = 0;
		int num=0;
		for(int i : arr) {
			cnt[i] ++;
		}
		//최빈값의 크기 확인
		for(int i = 0 ; i<cnt.length;i++)
		{
			if(frequency < cnt[i]) {
				frequency = cnt[i];
				num = i;
			}
		}
		//최빈값이 여러개인가?
		for(int i = 0 ; i< cnt.length;i++)
		{
			if(frequency == cnt[i])
				frequency_cnt++;
			
			if(frequency_cnt == 2) {
				sb.append(i-4000).append("\n");
				break;
			}
		}
		if(frequency_cnt == 1)
			sb.append(num-4000).append("\n");
		
		//범위
		int range = arr[arr.length-1] - arr[0];
		
		sb.append(range).append("\n");
		
		System.out.println(sb);
		
	}

}
