package Java_InsertionSort;

import java.io.*;
class InsertionSort 
{
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("몇개의 숫자를 입력하시겠습니까: ");

		int number = System.in.read() - 48;
		System.in.read();System.in.read();

		int array[] = new int[number];
		int swap = 0;

		System.out.println("삽입정렬을 할 " + number +"개의 숫자를 입력해주세요");
		System.out.println();

		for (int n = 0 ; n < array.length ; n++ ) {

			System.out.print((n + 1) +"번째 숫자 :");

			array[n] = System.in.read() - 48;
			System.in.read();System.in.read();
				
		} //end for

		System.out.println();
		System.out.println("지금부터 삽입정렬을 시작하겠습니다!!!");
		System.out.println();

		for (int after = 1; after < array.length; after++ ) { //기준이 되는건 after 비교 하면서 작은걸로 간다.

			for (int before = after; before > 0; before-- ) { //after의 전부터해서 앞으로 비교를 한다.

				if (array[before] < array[before -1]) {

					swap = array[before -1];
					array[before -1] = array[before];
					array[before] = swap;

				} 
			} // before end
		} // after end

		//결과 출력
		for (int i = 0; 0 < array.length; i++ ) {

			System.out.print(" [" + array[i] + "] ");			

		}
		System.out.println();

	}// end main

}
