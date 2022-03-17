import java.io.*;
import java.util.*;

public class Baekjoon_16987 {
	static int N,ans;
	static Egg eggs[] = new Egg[9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=1; i<=N; i++) {
			int s = sc.nextInt();
			int w = sc.nextInt();
			eggs[i] = new Egg(s,w);
		}
		
		dfs(1);
		
		System.out.println(ans);
	}
	
	public static void dfs(int idx) {
		if(idx > N) {
			int temp = 0;
			for(int i=1; i<=N; i++) {
				if(eggs[i].s <= 0) {
					temp++;
				}
			}
			ans = Math.max(ans, temp);
			return;
		}
		boolean flag = false;
		for(int i=1; i<=N; i++) {
			if(i==idx) continue;
			
			
			if(eggs[i].s > 0 && eggs[idx].s >0) {
				eggs[i].s -= eggs[idx].w;
				eggs[idx].s -= eggs[i].w;
				flag= true;	// 한 번이라도 부딪힌다면
				dfs(idx+1);
				
				eggs[i].s += eggs[idx].w;
				eggs[idx].s += eggs[i].w;
			}
			
		}
		
		if(!flag) dfs(idx+1);	// 한번도 부딪힌 적 없다면 오른쪽 달걀 조사
		
	}
	
	public static class Egg{
		int s;
		int w;
		Egg(int s, int w){
			this.s = s;
			this.w = w;
		}
	}

}
