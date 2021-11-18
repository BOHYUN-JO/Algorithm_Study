import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2565 {
	static int N;
	static Node[] arr;
	static ArrayList<Integer> vt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		vt = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Node tmp = new Node(a,b);
			arr[i] = tmp;
		}
		
		Arrays.sort(arr, (n1,n2) -> n1.a - n2.a);
		
		int cnt = 0;
		vt.add(Integer.MIN_VALUE);
		for(int i=0; i<N; i++) {
			int x = arr[i].b;
			if(vt.get(vt.size()-1) < x){
				vt.add(x);
				cnt++;
			}else {
				int idx = lowerBound(vt, x);
				vt.set(idx, x); 
			}
		}
		
		System.out.println(N-cnt);
	}
	
	private static class Node {
		int a;
		int b;
		Node(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
	private static int lowerBound(ArrayList<Integer> data, int target) {
		int begin = 0;
	    int end = data.size();
	    
	    while(begin < end) {
	    	int mid = (begin + end) / 2;
	        
	        if(data.get(mid) >= target) {
	        	end = mid;
	        }
	        else {
	        	begin = mid + 1;
	        }
	    }
	    return end;
	}

}
