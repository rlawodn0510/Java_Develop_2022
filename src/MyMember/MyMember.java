package MyMember;

import java.io.*;
import java.util.*;

class MyMember {
	// ���
	private String name;
	private int age;
	private String phoneNum;
	private String address;

	// ������ setting
	MyMember(String name, int age, String phoneNum, String address) { // ȸ�����Կ�

		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.address = address;
	}

	// �޼ҵ�
	String getName() { // �̸� ���� X

		return name;

	}

	int getAge() { // ���� ���� X

		return age;

	}

	void setPhoneNum(String phoneNum) { // ����ó ������

		this.phoneNum = phoneNum;

	}

	String getPhoneNum() { // ��ȣ ���� O

		return phoneNum;

	}

	void setAddress(String address) { // �ּ� ������

		this.address = address;

	}

	String getAddress() { // �ּ� ���� O

		return address;

	}

}

class MemManager {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Vector<MyMember> member = new Vector<MyMember>(); // ���ͻ���

		String name; // �̸�
		int age; // ����
		String phoneNum; // ��ȭ
		String address; // �ּ�

		int menu; // �޴�
		int chnMenu; // �������� �޴�
		boolean roof = false; // ����
		boolean chnRoof = false; // �����������

		String chkName = ""; // �̸�Ȯ��
		String chnPhoneNum; // ����ó ����
		String chnAddress; // �ּҷ� ����

		while (!roof) { // true�� �Ǹ� ����

			System.out.println("1.ȸ������ ");
			System.out.println("2.ȸ���˻� ");
			System.out.println("3.�������� ");
			System.out.println("4.ȸ��Ż�� ");
			System.out.println("5.��ü��� ");
			System.out.println("0.���α׷����� ");

			System.out.print("�޴����� : ");

			menu = System.in.read() - 48;
			System.in.read();
			System.in.read(); // �����Է� ����ó��
			System.out.println();

			if (menu == 1) { // ȸ������

				System.out.println();
				System.out.print("�̸� : ");
				name = br.readLine();
				System.out.print("���� : ");
				age = Integer.parseInt(br.readLine());
				System.out.print("��ȭ : ");
				phoneNum = br.readLine();
				System.out.print("�ּ� : ");
				address = br.readLine();

				member.add(new MyMember(name, age, phoneNum, address)); // ���� ����� ����

				System.out.println("���������� �����Ͽ����ϴ�.");
				System.out.println();

			} // 1 if end

			if (menu == 2) { // ȸ���˻�

				System.out.print("ã���ô� ȸ�� �̸� : ");
				chkName = br.readLine();

				for (int i = 0; i < member.size(); i++) {

					MyMember members = (MyMember) member.elementAt(i);

					if (chkName.equals(members.getName())) {

						System.out.println("�˻��� �����Ͽ����ϴ�.");
						System.out.println();

						chnRoof = true; // ���������� �㰡�Ѵ�.

					} // �̸� �´� if end

				} // ã�� for end

			} // 2 if end

			if (menu == 3) {

				if (chnRoof != true) {

					System.out.println("�˻��� ���� �����ϼž� �մϴ�.");
					System.out.println();
					continue;

				} else {

					do {

						System.out.println("1.����ó���� ");
						System.out.println("2.�ּҷϼ��� ");
						System.out.println("0.������� ");

						System.out.print("�޴����� : ");

						chnMenu = System.in.read() - 48;
						System.in.read();
						System.in.read(); // �����Է� ����ó��
						System.out.println();

						if (chnMenu == 1) { // ����ó����

							System.out.println(chkName + "�� ����ó������ �����մϴ�. ");
							System.out.print("������ ��ȣ : ");

							chnPhoneNum = br.readLine();

							for (int i = 0; i < member.size(); i++) {

								MyMember members = (MyMember) member.elementAt(i);

								if (chkName.equals(members.getName())) {

									members.setPhoneNum(chnPhoneNum);

								}

							}
							System.out.println("��ȭ��ȣ�� ���������� ����Ǿ����ϴ�.");
							System.out.println();
							break;

						} else if (chnMenu == 2) { // �ּҷϼ���

							System.out.println(chkName + "�� �ּҷ������� �����մϴ�. ");
							System.out.print("������ �ּ� : ");

							chnAddress = br.readLine();

							for (int i = 0; i < member.size(); i++) {

								MyMember members = (MyMember) member.elementAt(i);

								if (chkName.equals(members.getName())) {

									members.setAddress(chnAddress);

								}

							}
							System.out.println("�ּҰ� ���������� ����Ǿ����ϴ�.");
							System.out.println();
							break;

						} else if (chnMenu == 0) { // �������
							System.out.println(chkName + "���� ������ ����Ͽ����ϴ�.");
							System.out.println();
							break;
						}

					} while (chnMenu != 1 || chnMenu != 2 || chnMenu != 0);

				}

			}
			if (menu == 4) { // �ش��̸� ȸ��Ż��

				if (chnRoof != true) {

					System.out.println("�˻��� ���� �����ϼž� �մϴ�.");
					System.out.println();
					continue;

				} else {

					for (int n = 0; n < member.size(); n++) {

						MyMember members = (MyMember) member.elementAt(n);

						if (chkName.equals(members.getName())) {

							System.out.print(chkName + "�� ������ ���� �Ͻðڽ��ϱ�? (y/n) : ");
							char ans = (char) System.in.read();
							System.in.read();
							System.in.read();

							if (ans == 'y' || ans == 'Y') {

								member.removeElementAt(n); // ���Ϳ��� ����
								System.out.println("���������� ȸ��Ż�� �Ǿ����ϴ�.");
								System.out.println();
								chnRoof = false;
								chkName = "";

							}

						}

						menu = -1;

					}

				}

			} // Ż�� if end

			if (menu == 5) { // ��ü������

				for (int z = 0; z < member.size(); z++) {

					System.out.println();
					MyMember members = (MyMember) member.elementAt(z); // i��° �ع� ���
					System.out.println((z + 1) + "�� ȸ������");
					System.out.println("�̸� : " + members.getName());
					System.out.println("���� : " + members.getAge());
					System.out.println("��ȭ : " + members.getPhoneNum());
					System.out.println("�ּ� : " + members.getAddress());
					System.out.println();

				}

			} // ��ü������ end

			if (menu == 0) { // ���α׷�����

				System.out.print("����? : (y/n)");

				char ans = (char) System.in.read();
				System.in.read();
				System.in.read();

				if (ans == 'y' || ans == 'Y') {

					roof = true;

				} else {
					break;
				}

			}

		}

	}

}
