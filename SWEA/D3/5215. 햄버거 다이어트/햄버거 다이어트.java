import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int L;
	
	static int result;
	
	static Ingre[] kind;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1 ; tc <= T;tc++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			kind = new Ingre[N];
			//현재 입력받은 점수 및 칼로리를 저장해둠.
			for(int idx = 0;idx <N;idx++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int calro = Integer.parseInt(st.nextToken());
				
				Ingre ingre = new Ingre(score,calro);
				kind[idx] = ingre;
			}
			
			//위치,칼로리,맛 점수
			find(0,0,0);
			
			sb.append("#"+tc).append(" " + result).append("\n");
			
		}
		System.out.print(sb);
	}
	
	//재귀를 통해 진행
	//1 재료를 선택하는 경우
	//2 재료를 선택하지 않는 경우
	public static void find(int index,int sum,int favor) {
		
		//칼로리를 넘어가는경우 패스
		if(sum > L) {
			return;
		}
		
		//끝까지 전부 체크되는 경우 
		if(index == N) {
			result = Math.max(favor,result);
			return;
		}
		
		//맛 점수가 높은걸로 갱신
		result = Math.max(favor,result);
		
		//현재 재료를 선택하는 경우
		find(index+1,sum+kind[index].calro,favor+kind[index].score);
		//재료를 선택하지 않는 경우
		find(index+1,sum,favor);
	}
	
	
	//재료의 점수와 칼로리
	public static class Ingre{
		int score;
		int calro;
		
		public Ingre(int score,int calro) {
			this.score = score;
			this.calro = calro;
		}
	}

}