import java.util.*;

// Arrays.stream(array).sum() : 스트림API로 sum을 한번에 구할 수 있다.
// TreeMap은 키 순서로 정렬해서 저장해주는 맵이다.



public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		Map<Integer,Integer> map = new TreeMap<>();
		ArrayList<Integer> list = new ArrayList<>(); //빈도수 저장할 가변배열
		int maxFrequency;
		
		int max = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			int value = map.getOrDefault(arr[i], 0)+1;
			if(value>max)
				max = value;
			map.put(arr[i], value);
		}
		Arrays.sort(arr);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()==max)
				list.add(entry.getKey());
		}
		
		if(list.size()>1) { // 최빈값이 여러개이면,
			Collections.sort(list);
			maxFrequency = list.get(1);//두번째로 작은 것
		}
		else
			maxFrequency = list.get(0);
		
		

		
		double sum = (double)Arrays.stream(arr).sum()/N;
		
		//산술평균
		System.out.println((int)Math.round(sum));
		//중앙값
		System.out.println(arr[N/2]);
		//최빈값
		System.out.println(maxFrequency);
		//범위
		System.out.println(arr[N-1]-arr[0]);
		
		

	}
}