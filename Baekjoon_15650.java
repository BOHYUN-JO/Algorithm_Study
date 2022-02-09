import java.io.*;
import java.util.*;

public class Baekjoon_15650 {
	static int N, M;
	static int arr[];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		for(int i=1; i<=N ; i++ ) {
			arr[i-1] = i;
		}
		
		comb(0,M);
			
	}
	
	static void comb(int start, int r) {
		if(r == 0) {
			print();
			return;
		}
		
		for(int i=start; i<N; i++) {
			visited[i] = true;
			comb(i+1,r-1);
			visited[i] = false;
		}
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				System.out.print(arr[i] +" ");
			}
		}
		System.out.println();
	}

}
