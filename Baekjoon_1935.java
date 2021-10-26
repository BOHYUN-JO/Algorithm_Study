import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1935 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = new int[Integer.parseInt(br.readLine())];
		String str = br.readLine();
		
		for(int i=0; i< n.length; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		double d = 0;
		
		for(int i=0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c != '+' && c != '-' && c != '*' && c!= '/') {
				int num = c - 'A';
				stack.push((double)n[num]);
			}else {
				double a = stack.pop();
				double b = stack.pop();
				
				switch(c) {
				case '+':
					stack.push((double) (b+a) );
					break;
				case '-':
					stack.push((double)(b-a));
					break;
				case '*':
					stack.push((double)(b*a));
					break;
				case '/':
					stack.push((double)(b/a));
					break;
				}
			}
		}
		
		d= stack.pop();
		System.out.printf("%.2f", d);

	}

}
