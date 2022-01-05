package Java_Quiz;

import java.io.*;

class Phone {
	private String name;
	private int phoneNum;
	
	Phone(String name, int phoneNum) {

		this.name = name;
		this.phoneNum = phoneNum;
	}
	String getName() {
		return name;
	}
	int getphoneNum() {
		return phoneNum;
	}
}

class PhoneClass {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name;
		String chkName;
		int phoneNum;
		int n;

		System.out.print("인원수 >> ");
		int people = System.in.read() - 48;
		System.in.read();System.in.read();
		Phone phone[] = new Phone[people];

		for (int i = 0; i < people; i++) {

			System.out.print((i + 1) + "번째 이름/전화번호 :");

			name = br.readLine();
			phoneNum = Integer.parseInt(br.readLine());
			phone[i] = new Phone(name, phoneNum);
		} // end for
		System.out.println("저장되었습니다. ");
		System.out.println();

		System.out.print("검색할 이름 >> ");
		chkName = br.readLine();

		for (n = 0; n < phone.length; n++) {
			if (chkName.equals(phone[n].getName())) {
				System.out.println(chkName + "의 번호는 " + phone[n].getphoneNum() + " 입니다.");
				n--;
				break;
			}
		}
		if (chkName.equals("그만"))
			return;
		if (n == phone.length)
			System.out.println(chkName + "이 없습니다.");
	}
}
