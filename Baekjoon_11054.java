import java.util.*;

public class Baekjoon_11054 {

	public static void main(String[] args)   {
		Employee one = new Per();
		Employee two = new Sale();
		one.sabun = 1;
		one.name = "ii";
		two.sabun = 2;
		two.name = "ss";
		
		one.printE();
		two.printE();
	}
	
	static abstract class Employee{
		int sabun;
		String name;
		abstract int getSal();
		
		void printE() {
			System.out.print(sabun +"," + name+"," + getSal());
		}
	}
	
	static class Per extends Employee{
		int getSal() {
			return 100;
		}
	}
	
	static class Sale extends Per{
		int getSal() {
			return 10+super.getSal();
		}
	}
	
	
	
}
