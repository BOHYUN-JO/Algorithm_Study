import java.util.*;


public class Baekjoon_2078 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int lCnt = 0, rCnt=0;
		
		while(true) {
			if(a==1) {
				rCnt += b-1;
				break;
			}else if(b==1) {
				lCnt += a-1;
				break;
			}
			
			if(a>b) {
				lCnt += a/b;
				a %= b;
			}else {
				rCnt += b/a;
				b %= a;
			}
		}
		System.out.println(lCnt +" " + rCnt);
	}
}
