import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

public class Main {
	public static int M;
	public static Deque<Integer> s = new ArrayDeque<>();
	public static List<Integer> arr = new ArrayList<>();

	public static void add(Deque s, int x) {
		if (check(s, x))
			return;
		s.addLast(x);
	}

	public static void remove(Deque s, int x) {
		if (!check(s, x))
			return;
		s.remove(x);
	}

	public static boolean check(Deque s, int x) {
		if (s.contains(x))
			return true;
		return false;
	}

	public static void toggle(Deque S, int x) {
		if (check(s, x)) {
			s.remove(x);
			return;
		}
		s.add(x);
	}

	public static void all(Deque S) {
		s.clear();
		s.addAll(arr);
	}

	public static void empty(Deque S) {
		s.clear();
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < 20; i++) {
			arr.add(i + 1);
		}

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			String cmd = input[0];
			if (cmd.equals("add")) {
				int x = Integer.parseInt(input[1]);
				add(s, x);
			} else if (cmd.equals("remove")) {
				int x = Integer.parseInt(input[1]);
				remove(s, x);
			} else if (cmd.equals("check")) {
				int x = Integer.parseInt(input[1]);
				int result = check(s, x) ? 1 : 0;
				bw.write(result+"\n");
			} else if (cmd.equals("toggle")) {
				int x = Integer.parseInt(input[1]);
				toggle(s, x);
			} else if (cmd.equals("all")) {
				all(s);
			} else if (cmd.equals("empty")) {
				empty(s);
			}
		}
		bw.flush();
		br.close();
		bw.close();

	}
}