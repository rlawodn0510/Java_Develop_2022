package BubbleSort;

//버블정렬
import java.io.*;//---1

class BubbleSort {
	public static void main(String[] args) throws IOException { // ---2

		System.out.print("몇개의 숫자를 입력하시겠습니까: ");

		int number = System.in.read() - 48;
		System.in.read();
		System.in.read();

		int array[] = new int[number];
		int swap = 0;

		System.out.println("버블정렬을 할 " + number + "개의 숫자를 입력해주세요");
		System.out.println();

		for (int n = 0; n < array.length; n++) {

			System.out.print((n + 1) + "번째 숫자 :");

			array[n] = System.in.read() - 48;
			System.in.read();
			System.in.read();

		} // end for

		System.out.println();
		System.out.println("지금부터 버블정렬을 시작하겠습니다!!!");
		System.out.println();

		for (int count = 0; count < array.length - 1; count++) { // 길이 -1 만큼 반복합니다.

			for (int arr = 0; arr < array.length - 1; arr++) { // 배열의 앞뒤를 반복해서 비교

				if (array[arr] > array[arr + 1]) {

					swap = array[arr + 1];
					array[arr + 1] = array[arr];
					array[arr] = swap;

				}
			}
		}

		// 결과 출력

		System.out.println("결과는");
		for (int i = 0; 0 < array.length; i++) {

			System.out.print(" [" + array[i] + "] ");

		}
		System.out.println();

	}// end main

}
