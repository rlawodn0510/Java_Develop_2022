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

		System.out.print("�ο��� >> ");
		int people = System.in.read() - 48;
		System.in.read();System.in.read();
		Phone phone[] = new Phone[people];

		for (int i = 0; i < people; i++) {

			System.out.print((i + 1) + "��° �̸�/��ȭ��ȣ :");

			name = br.readLine();
			phoneNum = Integer.parseInt(br.readLine());
			phone[i] = new Phone(name, phoneNum);
		} // end for
		System.out.println("����Ǿ����ϴ�. ");
		System.out.println();

		System.out.print("�˻��� �̸� >> ");
		chkName = br.readLine();

		for (n = 0; n < phone.length; n++) {
			if (chkName.equals(phone[n].getName())) {
				System.out.println(chkName + "�� ��ȣ�� " + phone[n].getphoneNum() + " �Դϴ�.");
				n--;
				break;
			}
		}
		if (chkName.equals("�׸�"))
			return;
		if (n == phone.length)
			System.out.println(chkName + "�� �����ϴ�.");
	}
}
