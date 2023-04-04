import java.util.*;

public class Main {
	static int n,m;
	static long ans;
	static int[][] arr;
	
	public static void calculate(int[][] block) {
		long sum = 0;
		for(int x=0; x<n; x++) {
			for(int y=0; y<m; y++) {
				boolean flag = true;
				sum = 0;
				for(int k=0; k<4; k++) {
					int nx = x + block[k][0];
					int ny = y + block[k][1];
					if(nx <0 || ny < 0 || nx>= n || ny >=m) {
						flag = false;
						break;
					}
					
					sum += arr[nx][ny];
				}
				if(flag) {
					ans = Math.max(ans,sum);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int[][] block1 = {
				{0,0},
				{0,1},
				{0,2},
				{0,3}
		};
		int[][] block2 = {
				{0,0},
				{1,0},
				{2,0},
				{3,0}
		};
		int[][] block3 = {
				{0,0},
				{0,1},
				{1,0},
				{1,1}
		};
		int[][] block4 = {
				{0,0},
				{1,0},
				{2,0},
				{2,1}
		};
		int[][] block5 = {
				{0,0},
				{0,1},
				{0,2},
				{1,0}
		};
		int[][] block6 = {
				{0,0},
				{0,1},
				{1,1},
				{2,1}
		};
		int[][] block7 = {
				{0,0},
				{0,1},
				{0,2},
				{-1,2}
		};
		int[][] block8 = {
				{0,0},
				{1,0},
				{1,1},
				{2,1}
		};
		int[][] block9 = {
				{0,0},
				{0,1},
				{-1,1},
				{-1,2}
		};
		int[][] block10 = {
				{0,0},
				{0,1},
				{0,2},
				{1,1}
		};
		int[][] block11 = {
				{0,0},
				{0,1},
				{-1,1},
				{1,1}
		};
		int[][] block12 = {
				{0,0},
				{0,1},
				{0,2},
				{-1,1}
		};
		int[][] block13 = {
				{0,0},
				{1,0},
				{1,1},
				{2,0}
		};
		int[][] block14 = {
				{0,0},
				{0,1},
				{-1,1},
				{-2,1}
		};
		int[][] block15 = {
				{0,0},
				{1,0},
				{1,1},
				{1,2}
		};
		int[][] block16 = {
				{0,0},
				{0,1},
				{1,0},
				{2,0}
		};
		int[][] block17 = {
				{0,0},
				{0,1},
				{0,2},
				{1,2}
		};
		int[][] block18 = {
				{0,0},
				{-1,0},
				{-1,1},
				{-2,1}
		};
		int[][] block19 = {
				{0,0},
				{0,1},
				{1,1},
				{1,2}
		};
		
		
		calculate(block1); calculate(block2); calculate(block3);
		calculate(block4); calculate(block5); calculate(block6);
		calculate(block7); calculate(block8); calculate(block9);
		calculate(block10); calculate(block11); calculate(block12);
		calculate(block13); calculate(block14); calculate(block15); 
		calculate(block16); calculate(block17); calculate(block18); 
		calculate(block19);
		
		System.out.println(ans);
		
				
	}

}