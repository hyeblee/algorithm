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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static int T;
	public static StringBuilder sb = new StringBuilder("");
	
	public static void getResult(boolean isReversed, Deque<String> deque) {
		sb.append("[");
		if(isReversed) {
			while(true) {
				if(deque.isEmpty())
					break;
				sb.append(deque.pollLast());
				if(deque.isEmpty())
					break;
				sb.append(",");
			}
		}
		else {
			while(true) {
				if(deque.isEmpty())
					break;
				sb.append(deque.pollFirst());
				if(deque.isEmpty())
					break;
				sb.append(",");
			}
		}
		sb.append("]\n");
	}
	
	public static void compute(String p, Deque<String> deque) {
		boolean isReversed = false;
		for(char ch : p.toCharArray()) {
			if(ch=='R') {
				isReversed = !isReversed;
				continue;
			}
			if(deque.isEmpty()) {
				sb.append("error\n");
				return;
			}
			if(isReversed) {
				deque.pollLast();
			}
			else {
				deque.pollFirst();
			}
		}
		getResult(isReversed,deque);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(),"[,]");
			Deque<String> deque = new LinkedList<>();
			for(int j=0;j<n;j++) {
				deque.offerLast(st.nextToken());
			}
			compute(p,deque);
		}
		System.out.println(sb);
	}
	
}