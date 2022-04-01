import java.util.*; // contains Collections framework


class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		while (length-- != 0) {
			int I = sc.nextInt();
			int J = sc.nextInt();
			int[][] arr = new int[I][J];
			for (int i = 0; i < I; i++)
				for (int j = 0; j < J; j++) {
					arr[i][j] = sc.nextInt();
				}
			while (find(0, 0, arr, arr[0][0]) > 0) {

			}
			boolean ans = true;
			for (int i = 0; i < I; i++)
				for (int j = 0; j < J; j++) {
					if (arr[i][j] != 0) {
						ans = false;
						i = I;
						break;

					}
				}
			if (!ans)
				System.out.println("NO");
			else
				System.out.println("YES");
		}

	}

	static int find(int a, int b, int[][] arr, int min) {
		if (min > arr[a][b])
			min = arr[a][b];
		if (b + 1 < arr[0].length && arr[a][b + 1] > 0) {
			min = find(a, b + 1, arr, min);

		} else if (a + 1 < arr.length && arr[a + 1][b] > 0) {
			min = find(a + 1, b, arr, min);

		} else if (a == arr.length - 1 && b == arr[0].length - 1) {
			arr[a][b] -= min;
			return min;
		} else
			return 0;

		arr[a][b] -= min;
		return min;

	}

}