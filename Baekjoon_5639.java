import java.io.*;
import java.util.*;

public class Baekjoon_5639 {
	static Node root;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		root = new Node(Integer.parseInt(br.readLine()));
		String str;
		while(true) {
			str = br.readLine();
			if(str == null || str.equals("")) break;
			root.insert(Integer.parseInt(str));
		}
		postOrder(root);
	}
	
	public static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
		
	}
	
	
	public static class Node{
		public int data;
		public Node left;
		public Node right;
		
		Node(int data){
			this.data = data;
		}
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		void insert(int n) {
            if (n < this.data) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
		
	}

}
