
public class MatrixRotation {

	public static void main(String[] args) {
		String[][] indexMatrix = createIndexMatrix(4);
		printMatrix(indexMatrix);

		inPlaceRotation(indexMatrix);
		printMatrix(indexMatrix);
	}

	private static void inPlaceRotation(String a[][]) {
		int n = a.length - 1;
		int x = a.length / 2;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				String topValue = a[i][j];

				a[i][j] = a[n - j][i];
				a[n - j][i] = a[n - i][n - j];
				a[n - i][n - j] = a[j][n - i];
				a[j][n - i] = topValue;
			}
		}
		System.out.println("Rotation complete !");
	}

	private static String[][] createIndexMatrix(int n) {
		String a[][] = new String[n][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = i + "" + j;
			}
		}
		return a;
	}

	private static void printMatrix(String a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
