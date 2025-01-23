import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static int N;
	public static int x;
	public static PriorityQueue<Integer> queue = new PriorityQueue<>(
			(a,b)-> Integer.compare(a, b)*(-1));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(queue.isEmpty()) 
					bw.write("0\n");
				else
					bw.write(queue.poll()+"\n");
			}
			else {
				queue.offer(x);
			}
		}
		bw.flush();
	}
}