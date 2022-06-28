import java.util.*;

public class NthNumber {
	static TreeSet<Long> set = new TreeSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		findNth(n);

	}
	
	public static void findNth(int n) {
		 
		long upper = (long)n*(long)(n+1);
		
		int digit = 1;
		boolean flag = true;
		
		while(flag) {
			digit++;
			flag = false;
			long k = 1;
			while(true) {
				long sum = k;
				for(int i=1; i<digit; i++) {
					sum *= k+i;
				}
				if(sum > upper) {
					break;
				}
				flag = true;
				set.add(sum);
				k++;
			}	
		}
		
		int idx = 0;
		for(Long cur : set) {
			idx++;
			if(idx == n) {
				System.out.println(cur); 
				break;
			}
		}
		
	}

}
