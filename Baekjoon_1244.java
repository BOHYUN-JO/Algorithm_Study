import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1244 {
	static int switchN, studentN;
	static int[] arr = new int[101];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switchN = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=switchN; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		studentN = Integer.parseInt(br.readLine());
		for(int i=0; i<studentN; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(sex == 1 ) {
				male(num);
			}else{
				female(num);
			}
		}
		
		for(int i=1; i<=switchN; i++) {
			if(i % 20 ==0) {
				System.out.println(arr[i]);
			}else {
				System.out.printf("%d ", arr[i]);
			}
		}
	}
	
	private static void male(int num) {
		for(int i=num; i<=switchN; i += num) {
			if(arr[i] == 0) arr[i] = 1;
			else arr[i] = 0;
		}
	}
	
	private static void female(int num) {
		int i=num,a,b;
		a = i-1;
		b = i+1;
		if(arr[i] == 0) arr[i] = 1;
		else arr[i] = 0;
		if(a<1 || b > switchN) return;
		while(true) {
			if(arr[a] == arr[b]) {
				if(arr[a] == 1) arr[a] = 0;
				else arr[a] = 1;
				if(arr[b] == 1) arr[b] = 0;
				else arr[b] = 1;
				
				a -=1;
				b +=1;
				if(a<1 || b>switchN) break;
			}else break;
		}
	}

}
