package Java_MabangJin;

import java.io.*;//---1

class MabangJin {
	public static void main(String[] args) throws IOException { // ---2

		System.out.print("숫자(홀수만) : ");
		int num = System.in.read() - 48;
		System.in.read();
		System.in.read();

		int[][] mabang = new int[num][num];// 배열생성

		int row = 0;
		int col = num / 2;

		for (int su = 1; su <= num * num; su++) {

			mabang[row][col] = su;

			if ((su % num) == 0) {
				row++; // num의 배수인 경우는 내린다
				continue;
			}
			col++; // 가로로 1개이동 (일반)
			row--; // 위로 1개이동 (일반)

			if (row < 0) {
				row = (num - 1); // 천장에 닿은 경우 (row가 0일 경우) 맨 아래로 넘김
				continue;
			}

			if (col > (num - 1)) {
				col = 0; // 벽인 경우는 맨 오른쪽으로 간다
				continue;
			}

		} // for end

		// 결과출력
		System.out.println();

		for (int i = 0; i < mabang.length; i++) {

			for (int j = 0; j < mabang[i].length; j++) {

				System.out.print(mabang[i][j] + "\t");

			}

			System.out.println();

		}
	}
}
