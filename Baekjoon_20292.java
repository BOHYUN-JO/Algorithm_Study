import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_20292 {
	static ArrayList<String> list = new ArrayList<>();
	static HashMap<String, String> writeFromTo = new HashMap<>();
	static HashMap<String, String> writeToFrom = new HashMap<>();
	static HashSet<String> read = new HashSet<>();
	static ArrayList<String> ans = new ArrayList<>();	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String tmp = br.readLine();
			list.add(tmp);
			if(tmp.equals("EXIT")) break;
		}
		
		for(int i=0; i<list.size()-1; i++) {
			String[] arr = list.get(i).split(" ");
			String a= "";
			String b= "";
			
			if(arr[0].equals("WRITE")) {
				a = arr[1];
				b = arr[3];
				if(read.contains(b)) {
					ans.add("WAIT");
					clear();
				}else if(writeFromTo.containsKey(b) || writeToFrom.containsKey(a)) {
					ans.add("WAIT");
					clear();
				}else if(writeToFrom.containsKey(b) || writeToFrom.containsKey(a)) {
					ans.add("WAIT");
					clear();
				}
				writeFromTo.put(a, b);
				writeToFrom.put(b, a);
				ans.add(list.get(i));
			}else{
				a = arr[1];
				
				if(writeToFrom.containsKey(a)) {
					ans.add("WAIT");
					clear();
				}
				read.add(a);
				ans.add(list.get(i));
			}
		}
		ans.add("EXIT");
		
		for(int i=0;i <ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		
		 
	}
	
	private static void clear() {
		writeFromTo.clear();
		writeToFrom.clear();
		read.clear();
	}

}
