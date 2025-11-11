

import java.util.*;

class Node {
	int freq;
	char ch;
	Node left;
	Node right;
	Node(char ch, int freq){
		this.ch = ch;
		this.freq = freq;
	}
	
	Node(int freq, Node left, Node right){
		this.ch = '-';
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
	
}


class Huffman{
	public static void printCodes(Node root, String code) {
		if(root == null) return;
		
		if(root.left == null && root.right == null && root.ch != '-') {
			System.out.println(root.ch+": "+code);
		}
		printCodes(root.left, code+"0");
		printCodes(root.right, code+"1");
	}
}

public class HuffmanCoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();
        
        char[] chars = new char[n];
        int[] freq = new int[n];
        
        System.out.println("Enter characters and thier frequencies: ");
        for(int i = 0; i<n; i++) {
        	chars[i] = sc.next().charAt(0);
        	freq[i] = sc.nextInt();
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.freq));
        
        for(int i = 0; i<n; i++) {
        	pq.add(new Node(chars[i],freq[i]));
        }
        
        while(pq.size() > 1) {
        	Node left = pq.poll();
        	Node right = pq.poll();
        	
        	Node newNode = new Node(left.freq+right.freq, left, right);
        	pq.add(newNode);
        }
        
        Node root = pq.poll();
        System.out.println("Huffman codes:");
        Huffman.printCodes(root, "");
        
        sc.close();
        
    }
}