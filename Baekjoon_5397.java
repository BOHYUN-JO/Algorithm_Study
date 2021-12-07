import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon_5397 {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String str = br.readLine();
			LinkedList<Character> list = new LinkedList<>();
			int idx = 0;
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ch =='<') {
					if(idx > 0) idx--;
				}else if(ch =='>') {
					if(idx <list.size()) {
						idx++;
					}
				}else if(ch=='-') {
					if(idx > 0) {
						list.remove(idx-1);
						idx--;
					}
				}else {
					list.add(ch);
					idx++;
				}
			}
			
			for(int i=0;i<list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}

}
