package BubbleSort;

//��������
import java.io.*;//---1

class BubbleSort {
	public static void main(String[] args) throws IOException { // ---2

		System.out.print("��� ���ڸ� �Է��Ͻðڽ��ϱ�: ");

		int number = System.in.read() - 48;
		System.in.read();
		System.in.read();

		int array[] = new int[number];
		int swap = 0;

		System.out.println("���������� �� " + number + "���� ���ڸ� �Է����ּ���");
		System.out.println();

		for (int n = 0; n < array.length; n++) {

			System.out.print((n + 1) + "��° ���� :");

			array[n] = System.in.read() - 48;
			System.in.read();
			System.in.read();

		} // end for

		System.out.println();
		System.out.println("���ݺ��� ���������� �����ϰڽ��ϴ�!!!");
		System.out.println();

		for (int count = 0; count < array.length - 1; count++) { // ���� -1 ��ŭ �ݺ��մϴ�.

			for (int arr = 0; arr < array.length - 1; arr++) { // �迭�� �յڸ� �ݺ��ؼ� ��

				if (array[arr] > array[arr + 1]) {

					swap = array[arr + 1];
					array[arr + 1] = array[arr];
					array[arr] = swap;

				}
			}
		}

		// ��� ���

		System.out.println("�����");
		for (int i = 0; 0 < array.length; i++) {

			System.out.print(" [" + array[i] + "] ");

		}
		System.out.println();

	}// end main

}
