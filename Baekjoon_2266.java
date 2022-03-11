import java.io.*;
import java.util.*;

public class Baekjoon_2266 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int dp[][] = new int[N+1][K+1];	
		// dp[i][j] : i������ j���� �ݰ� ����߸��� �ʿ��� �ּ� Ƚ��
		
		
		/* 1�������� ���� 1������ �ʿ��� */
		for(int i=1; i<=K; i++) {
			dp[1][i] = 1;
		}
		
		/* ���ڰ� 1���� ������ 1������ �� ����Ʈ���� �� */
		for(int i=1; i<=N; i++) {
			dp[i][1] = i;
		}
		
		for(int i=2; i<=K; i++) {
			for(int j=2; j<=N; j++) {
				dp[j][i] = Integer.MAX_VALUE;
				for(int f = 1; f<=j; f++) {
					int temp = 1+(Math.max(dp[f-1][i-1], dp[j-f][i]));
					dp[j][i] = Math.min(dp[j][i], temp);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
