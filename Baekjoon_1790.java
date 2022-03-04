import java.io.*;
import java.util.*;

public class Baekjoon_1790 {
	static int N,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		long target = 0;	// ã�� ���ڰ� ���Ե� ����
		long numLen = 1;	// ����ؼ� �ø� �ڸ���
		long numCnt = 9;	// 9,90,900~
		
		while(K > numCnt*numLen) {
			K -= (numLen*numCnt);
			target += numCnt;
			
			numLen++;
			numCnt *=10;
		}
		
		target = (target+1) + (K-1)/numLen;	// ã���� �ϴ� ���ڰ� ���Ե� ���� 
		
		if(target > N) {
			System.out.println(-1);
		}else {
			int idx = (int)((K-1)%numLen);
			System.out.println(String.valueOf(target).charAt(idx));
		}
	}
}
