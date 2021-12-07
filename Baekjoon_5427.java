import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_5427 {
	static int T, w,h, cnt;
	static char[][] arr;
	static Queue<Pair> fire;
	static Queue<Pair> human;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new char[h+1][w+1];
			fire = new LinkedList<Pair>();
			human = new LinkedList<>();
			cnt = 0;
			for(int i=0; i<h; i++) {
				String str = br.readLine();
				for(int j=0; j<w; j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j] == '*') {
						fire.add(new Pair(i,j));
					}else if(arr[i][j] == '@') {
						human.add(new Pair(i,j));
					}
				}
			}
			while(true) {
				if(bfsHuman()) {
					System.out.println(cnt);
					break;
				}
				
				bfsFire();
				
				if(human.size() == 0) {
					System.out.println("IMPOSSIBLE");
					break;
				}
			}	
		}
		
	}
	
	static private boolean bfsFire() {
		int size = fire.size();
		while(size-- > 0) {
			int cx = fire.peek().x;
			int cy = fire.peek().y;
			fire.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx<0 || ny <0 || nx >=h || ny >=w) continue;
				
				if(arr[nx][ny] != '#' && arr[nx][ny] != '*') {
					fire.add(new Pair(nx,ny));
					arr[nx][ny] = '*';
				}
			}
		}
		
		return false;
	}
	
	static private boolean bfsHuman() {
		cnt++;
		int size = human.size();
		while(size-- > 0) {
			int cx = human.peek().x;
			int cy = human.peek().y;
			human.poll();
			
			if(arr[cx][cy] == '*') {
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx<0 || ny <0 || nx >=h || ny >=w) return true;
				
				if(arr[nx][ny] == '.' && arr[cx][cy] == '@') {
					human.add(new Pair(nx,ny));
					arr[nx][ny] = '@';
				}
			}
		}
		
		return false;
	}
	
	static public class Pair{
		int x;
		int y;
		Pair(int a, int b){
			this.x = a;
			this.y = b;
		}
	}

}
