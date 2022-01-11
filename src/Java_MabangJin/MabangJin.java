package Java_MabangJin;

import java.io.*;//---1

class MabangJin {
	public static void main(String[] args) throws IOException { // ---2

		System.out.print("����(Ȧ����) : ");
		int num = System.in.read() - 48;
		System.in.read();
		System.in.read();

		int[][] mabang = new int[num][num];// �迭����

		int row = 0;
		int col = num / 2;

		for (int su = 1; su <= num * num; su++) {

			mabang[row][col] = su;

			if ((su % num) == 0) {
				row++; // num�� ����� ���� ������
				continue;
			}
			col++; // ���η� 1���̵� (�Ϲ�)
			row--; // ���� 1���̵� (�Ϲ�)

			if (row < 0) {
				row = (num - 1); // õ�忡 ���� ��� (row�� 0�� ���) �� �Ʒ��� �ѱ�
				continue;
			}

			if (col > (num - 1)) {
				col = 0; // ���� ���� �� ���������� ����
				continue;
			}

		} // for end

		// ������
		System.out.println();

		for (int i = 0; i < mabang.length; i++) {

			for (int j = 0; j < mabang[i].length; j++) {

				System.out.print(mabang[i][j] + "\t");

			}

			System.out.println();

		}
	}
}
