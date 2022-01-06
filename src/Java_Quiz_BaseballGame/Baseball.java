package Java_Quiz_BaseballGame;

import java.io.*;

class Baseball {
	public static void main(String[] args) throws IOException { 

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));

		int randomNum[] = new int[3]; // ���� ���� 3�ڸ�
		int yourNum[] = new int[3]; // ���� �����ϴ� ���� 3�ڸ�
		int count = 0; // ��� �ߴ���
		int scount = 0; // ��Ʈ����ũ ī��Ʈ
		int bcount = 0; // �� ī��Ʈ
		char start = 'y'; // ������ ��������
		boolean again = false;
		boolean gameOut = false;

		System.out.print("������ �����Ͻðڽ��ϱ�? (y/n)");
		start = (char) System.in.read();
		System.in.read();
		System.in.read();

		if (start != 'y') {

			System.exit(0);

		}

		System.out.println("��ǻ�Ͱ� �����ϰ� 3�ڸ����� ����ϴ�!");

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

		} // end while ��ǻ�Ͱ� �����ϰ� 3�ڸ��� ���� �迭�� �����.

		System.out.println();

		while (!gameOut) {

			count++;

			System.out.print("����� �����ϴ� ���ڴ�(3�ڸ� ��� �ٸ���) :");

			for (int n = 0; n < yourNum.length; n++) {

				yourNum[n] = System.in.read() - 48;

			} // end for ���� �����ϴ� ���� 3�ڸ� �Է�

			System.in.read();
			System.in.read();
			System.out.print(count + "�� : ");

			for (int y = 0; y < randomNum.length; y++) {

				for (int z = 0; z < yourNum.length; z++) {

					if (randomNum[y] == yourNum[z] && y == z) {

						scount += 1;

					} else if (randomNum[y] == yourNum[z]) {

						bcount += 1;

					} // end if

				} // end for

			} // end for

			System.out.println(scount + "��Ʈ����ũ" + bcount + "��");
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

		System.out.println("����� �¸��Ͽ����ϴ�!");

	} // end main

}
