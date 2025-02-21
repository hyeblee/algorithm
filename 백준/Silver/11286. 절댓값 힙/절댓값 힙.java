import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static class myComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b) {
			if(Math.abs(a)==Math.abs(b))
				return Integer.compare(a, b);
			return Integer.compare(Math.abs(a), Math.abs(b));
		}
	}
	
	
	
	public static PriorityQueue pq = new PriorityQueue<>(new myComparator());
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.isEmpty())
					bw.write("0\n");
				else
					bw.write(pq.poll()+"\n");
				continue;	
			}
			pq.offer(x);
		}
		bw.flush();
		br.close();
		bw.close();
	}
}