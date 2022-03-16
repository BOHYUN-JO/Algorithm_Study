import java.io.*;
import java.util.*;

public class Baekjoon_4358 {
	static TreeMap<String, Double> dict = new TreeMap<>();
	static double sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = "";
		while( (name = br.readLine()) != null && name.length() !=0 ) {
			sum++;
			dict.compute(name, (k,v) -> v==null ? 1 : v+1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(String key : dict.keySet()) {
			double ret = (double) dict.get(key)*100.0/sum;
			sb.append(key +" " + String.format("%.4f", ret)+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

}
