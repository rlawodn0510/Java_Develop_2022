package Java_InsertionSort;

import java.io.*;
class InsertionSort 
{
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("��� ���ڸ� �Է��Ͻðڽ��ϱ�: ");

		int number = System.in.read() - 48;
		System.in.read();System.in.read();

		int array[] = new int[number];
		int swap = 0;

		System.out.println("���������� �� " + number +"���� ���ڸ� �Է����ּ���");
		System.out.println();

		for (int n = 0 ; n < array.length ; n++ ) {

			System.out.print((n + 1) +"��° ���� :");

			array[n] = System.in.read() - 48;
			System.in.read();System.in.read();
				
		} //end for

		System.out.println();
		System.out.println("���ݺ��� ���������� �����ϰڽ��ϴ�!!!");
		System.out.println();

		for (int after = 1; after < array.length; after++ ) { //������ �Ǵ°� after �� �ϸ鼭 �����ɷ� ����.

			for (int before = after; before > 0; before-- ) { //after�� �������ؼ� ������ �񱳸� �Ѵ�.

				if (array[before] < array[before -1]) {

					swap = array[before -1];
					array[before -1] = array[before];
					array[before] = swap;

				} 
			} // before end
		} // after end

		//��� ���
		for (int i = 0; 0 < array.length; i++ ) {

			System.out.print(" [" + array[i] + "] ");			

		}
		System.out.println();

	}// end main

}
