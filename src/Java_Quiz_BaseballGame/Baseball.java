package Java_Quiz_BaseballGame;

import java.io.*;

class Baseball {
	public static void main(String[] args) throws IOException { 

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));

		int randomNum[] = new int[3]; // 랜덤 숫자 3자리
		int yourNum[] = new int[3]; // 내가 생각하는 숫자 3자리
		int count = 0; // 몇구를 했는지
		int scount = 0; // 스트라이크 카운트
		int bcount = 0; // 볼 카운트
		char start = 'y'; // 게임을 실행할지
		boolean again = false;
		boolean gameOut = false;

		System.out.print("게임을 실행하시겠습니까? (y/n)");
		start = (char) System.in.read();
		System.in.read();
		System.in.read();

		if (start != 'y') {

			System.exit(0);

		}

		System.out.println("컴퓨터가 랜덤하게 3자리수를 만듭니다!");

		while (!again) {

			for (int n = 0; n < randomNum.length; n++) {

				randomNum[n] = ((int) (Math.random() * 9) + 1);

			}

			if (randomNum[0] != randomNum[1] && randomNum[1] != randomNum[2] && randomNum[0] != randomNum[2]) {

				again = true;

			} else {

				again = false;

			} // end if

			continue;

		} // end while 컴퓨터가 랜덤하게 3자리의 숫자 배열을 만든다.

		System.out.println();

		while (!gameOut) {

			count++;

			System.out.print("당신이 생각하는 숫자는(3자리 모두 다르게) :");

			for (int n = 0; n < yourNum.length; n++) {

				yourNum[n] = System.in.read() - 48;

			} // end for 내가 생각하는 숫자 3자리 입력

			System.in.read();
			System.in.read();
			System.out.print(count + "구 : ");

			for (int y = 0; y < randomNum.length; y++) {

				for (int z = 0; z < yourNum.length; z++) {

					if (randomNum[y] == yourNum[z] && y == z) {

						scount += 1;

					} else if (randomNum[y] == yourNum[z]) {

						bcount += 1;

					} // end if

				} // end for

			} // end for

			System.out.println(scount + "스트라이크" + bcount + "볼");
			System.out.println();

			if (scount == 3) {

				gameOut = true;

			} else {

				gameOut = false;
				scount = 0;
				bcount = 0;

			} // end if

			System.out.println();
			continue;

		} // end while

		System.out.println("당신이 승리하였습니다!");

	} // end main

}
