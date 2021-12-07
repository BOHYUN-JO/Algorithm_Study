import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1963 {
	static int T, a,b, ans;
	static HashSet<Integer> set;
	static HashSet<Integer> prime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		prime = new HashSet<>();
		
		for(int i=1000; i<10000; i++) {
			if(isPrime(i)) {
				prime.add(i);
			}
		}
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ans = 0;
			set = new HashSet<>();
			if(bfs()) {
				System.out.println(ans);
			}else {
				System.out.println("Impossible");
			}
		}
	}
	
	private static boolean isPrime(int num) {
		for(int i=2; i<= Math.sqrt(num); i++) {
			if(num % i ==0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean bfs() {
		set.add(a);
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(a,0));
		
		while(!q.isEmpty()) {
			int cur = q.peek().num;
			int cnt = q.peek().cnt;
			q.poll();
			
			if(cur == b) {
				ans = cnt;
				return true;
			}
			String str = Integer.toString(cur);
			for(int i=0; i<4;i++) {
				char[] copy = str.toCharArray();
				for(int j=0; j<10; j++) {
					if(i==0 && j==0) continue;
					copy[i] = Integer.toString(j).charAt(0);
					int temp = Integer.parseInt( String.valueOf(copy)  );
					if(!set.contains(temp) && prime.contains(temp)) {
						q.add(new Pair(temp, cnt+1) );
						set.add(temp);
					}
				}
			}
		}
		
		return false;
	}
	
	static public class Pair{
		int num;
		int cnt;
		Pair(int x, int y) {
			this.num = x;
			this.cnt = y;
		}
	}

}
