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
	public static int n,m,v;
	public static boolean[] visit;
	public static int[][] graph;
	public static StringBuilder sb = new StringBuilder("");
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		// replaceAll은 정규표현식을 사용하기 때문에 +는 특수문자 처리 해줘야 한다.
		str = str.replaceAll("\\+", " "); 
		str = str.replaceAll("\\-", " -");
		
		
		String[] numbers = str.split(" ");
		
		int result = 0;
		int sign = 1;
		
		for(String number : numbers) {
			int numeric = Integer.parseInt(number);
			if(numeric < 0) { // 음수면 부호를 음수로 바꾼다.
				sign = -1;
				result += numeric;
				continue;
			}
			result += sign * numeric;
		}
		
		System.out.println(result);
	}
}
