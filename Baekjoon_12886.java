import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_12886 {
	static int A,B,C;
	static HashSet<String> visit = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		if(bfs()) {
			System.out.println("1");
		}else System.out.println("0");
	}
	
	public static boolean bfs() {
		boolean flag = false;
		Queue<Tuple> q = new LinkedList<Tuple>();
		q.add(new Tuple(A,B,C));
		visit.add(Integer.toString(q.peek().arr[0])+Integer.toString(q.peek().arr[1])+Integer.toString(q.peek().arr[2]) );
		while(!q.isEmpty()) {
			int a = q.peek().arr[0];
			int b = q.peek().arr[1];
			int c = q.peek().arr[2];
			q.remove();
			
			if(a==b && a==c && b==c) {
				flag = true;
				break;
			}
			Tuple tmp; 		
			if(a<b) {
				tmp = new Tuple(a+a,b-a,c);
				if(check(tmp)) {
					visit.add(Integer.toString(tmp.arr[0])+ Integer.toString(tmp.arr[1])+Integer.toString(tmp.arr[2]) );
					q.add(tmp);
				}
			}
			if(a<c) {
				tmp = new Tuple(a+a,b,c-a);
				if(check(tmp)) {
					visit.add(Integer.toString(tmp.arr[0])+ Integer.toString(tmp.arr[1])+Integer.toString(tmp.arr[2]) );
					q.add(tmp);
				}
			}
			if(b<c) {
				tmp = new Tuple(a,b+b,c-b);
				if(check(tmp)) {
					visit.add(Integer.toString(tmp.arr[0])+ Integer.toString(tmp.arr[1])+Integer.toString(tmp.arr[2]) );
					q.add(tmp);
				}
			}
			
		}
		return flag;
		
	}
	
	public static boolean check(Tuple t) {
		if(t.arr[0] == 0 || t.arr[1] == 0 || t.arr[2] == 0) {
			return false;
		}
		if(visit.contains(Integer.toString(t.arr[0])+ Integer.toString(t.arr[1])+Integer.toString(t.arr[2]))) {
			return false;
		}
		return true;
	}
	
	static class Tuple{
		public int arr[] = new int[3];
		Tuple(int a, int b, int c){
			this.arr[0] = a;
			this.arr[1] = b;
			this.arr[2] = c;
			Arrays.sort(arr);
		}
		
	}

}
