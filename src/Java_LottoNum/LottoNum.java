package Java_LottoNum;

import java.io.*;//---1

class LottoNum {
	public static void main(String[] args) throws IOException { // ---2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lotto[][]; // 로또 저장할 배열공간 선언

		int cnt = 0; // my project start

		System.out.print("몇 게임을 하실꺼에요 ? ");
		int number = Integer.parseInt(br.readLine());

		lotto = new int[number][6]; // 2차원 배열 초기화

		for (int i = 0; i < number; i++) {// 내가 선택 게임수 만큼

			cnt = 0;

			for (int j = 0; j < lotto[i].length; j++) {

				lotto[i][j] = (int) (Math.random() * 45) + 1;

				for (int k = 0; k < j; k++) {

					if (lotto[i][j] == lotto[i][k]) {

						j = j - 1;
						break;

					}

				}

			}

			for (int q = 0; q < i; q++) {

				for (int w = 0; w < lotto[i].length; w++) {

					for (int z = 0; z < lotto[q].length; z++) {

						if (lotto[i][w] == lotto[q][z]) {

							cnt++;
							break;

						}

					}

					if (cnt == w) {

						break;

					}

				}

				if (cnt == 6) { // lotto[i].length = 6

					i--;
					break;

				}

			}

		}

		// 결과출력
		for (int i = 0; i < number; i++) {

			System.out.print("\t" + (i + 1) + "번째 추천번호 : ");

			for (int j = 0; j < lotto[i].length; j++) {

				int temp;

				for (int x = 0; x < lotto[i].length - 1; x++) {
					for (int z = 0; z < lotto[i].length - 1; z++) {
						if (lotto[i][z] > lotto[i][z + 1]) {
							temp = lotto[i][z];
							lotto[i][z] = lotto[i][z + 1];
							lotto[i][z + 1] = temp;
						}
					}
				}

				if (lotto[i][j] >= 10) {

					System.out.print(" " + lotto[i][j]);

				} else {

					System.out.print(" " + lotto[i][j]);
				}

			}

			System.out.println();

		}

	} // end main

}
