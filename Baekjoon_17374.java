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
			
			coin = (Q/C)*D;		// ���� -> ����
			P += (coin/B)*A;	// ���� -> ��Ʈ
			coin = coin % B;	// ��Ʈ�� �ٲٰ� ���� ����
			
			int x = (P-coin)/(A+B);	// (coin+Bx)=(P-Ax) ���� ���ϱ�
			
			/*[x]+1 ���� �����ؼ� Ȯ��  */
			int ans = Math.max(Math.min(coin+(B*x), P-(A*x)),
					Math.min(coin+(B*(x+1)), P-(A*(x+1))));
			
			System.out.println(ans);	
		}
	}
}
