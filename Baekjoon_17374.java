import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon_17374 {
	static int T,P,Q,A,B,C,D, coin, bitcoin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			coin = (Q/C)*D;		// 베리 -> 코인
			P += (coin/B)*A;	// 코인 -> 비트
			coin = coin % B;	// 비트로 바꾸고 남은 코인
			
			int x = (P-coin)/(A+B);	// (coin+Bx)=(P-Ax) 교점 구하기
			
			/*[x]+1 값도 포함해서 확인  */
			int ans = Math.max(Math.min(coin+(B*x), P-(A*x)),
					Math.min(coin+(B*(x+1)), P-(A*(x+1))));
			
			System.out.println(ans);	
		}
	}
}
