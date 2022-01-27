import java.util.*;
import java.io.*;

public class Baekjoon_1629 {
	static int A,B,C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
	    B = sc.nextInt();
		C = sc.nextInt();
		System.out.println(pow(B));
	}

	private static long pow(int b) {
		if (b == 0)
			return 1;
		long tmp = pow(b/2);
		tmp = tmp * tmp % C;
		if (b%2==0)
			return tmp;
		return A*tmp%C;
	}
	
}
