package SelectionSort;

import java.io.*;//---1

class SelectionSort {
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

			for (int arr = (count + 1); arr < array.length; arr++) { // �� ���� �߽����� �ؼ� ���ʰ� �񱳸� �Ѵ�.

				if (array[count] > array[arr]) {

					swap = array[arr];
					array[arr] = array[count];
					array[count] = swap;

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