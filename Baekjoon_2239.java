import java.io.*;
import java.util.*;

public class Baekjoon_2239 {
	static int map[][] = new int[10][10];
	static HashSet<Integer> row[] = new HashSet[10];
	static HashSet<Integer> col[] = new HashSet[10];
	static HashSet<Integer> board[] = new HashSet[10];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/* 숫자 체크 */
		for(int i=1; i<=9; i++) {
			row[i] = new HashSet<>();
			col[i] = new HashSet<>();
			board[i] = new HashSet<>();
		}
		
		for(int i=1; i<=9; i++) {
			String str = br.readLine();
			for(int j=1; j<=9; j++) {
				int num = str.charAt(j-1)-'0';
				map[i][j] = num;
				if(num !=0) {
					row[i].add(num);
					col[j].add(num);
					board[((i-1)/3+1)*3-2+(j-1)/3].add(num);
				}
			}
		}
		
		dfs(1,1);
		
	}
	
	public static void dfs(int x, int y) {
		
		/* 모든 좌표에 원소 넣음 */
		if(x >= 9 && y > 9) {
			for(int i=1; i<=9 ; i++) {
				for(int j=1; j<=9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		/* 가로줄 다 봤으면 아래로 이동 */
		if(y>9) {
			dfs(x+1,1);
			return;
		} 
		
		/* 0일때만 체크 */
		if(map[x][y] == 0){
			for(int i=1; i<=9 ; i++) {
				if(check(x,y,i)) {	// 가로,세로,3*3 보드에 해당 숫자가 없다면
					map[x][y] = i;
					row[x].add(i);
					col[y].add(i);
					board[((x-1)/3+1)*3-2+(y-1)/3].add(i);
					dfs(x,y+1);
					map[x][y] = 0;
					row[x].remove(i);
					col[y].remove(i);
					board[((x-1)/3+1)*3-2+(y-1)/3].remove(i);
				}
			}
		}else {	// 아니면 오른쪽으로 한 칸 이동
			dfs(x,y+1);
		}
		
	}
	
	/* 가로, 세로, 3*3 보드에 해당 숫자가 있는지 체크 */
	public static boolean check(int x, int y, int num) {
		if(!row[x].contains(num) && !col[y].contains(num) && !board[((x-1)/3+1)*3-2+(y-1)/3].contains(num) ) {
			return true;
		}
		return false;
	}

}
