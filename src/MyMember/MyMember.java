package MyMember;

import java.io.*;
import java.util.*;

class MyMember {
	// 멤버
	private String name;
	private int age;
	private String phoneNum;
	private String address;

	// 생성자 setting
	MyMember(String name, int age, String phoneNum, String address) { // 회원가입용

		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.address = address;
	}

	// 메소드
	String getName() { // 이름 수정 X

		return name;

	}

	int getAge() { // 나이 수정 X

		return age;

	}

	void setPhoneNum(String phoneNum) { // 연락처 수정용

		this.phoneNum = phoneNum;

	}

	String getPhoneNum() { // 번호 수정 O

		return phoneNum;

	}

	void setAddress(String address) { // 주소 수정용

		this.address = address;

	}

	String getAddress() { // 주소 수정 O

		return address;

	}

}

class MemManager {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Vector<MyMember> member = new Vector<MyMember>(); // 벡터생성

		String name; // 이름
		int age; // 나이
		String phoneNum; // 전화
		String address; // 주소

		int menu; // 메뉴
		int chnMenu; // 정보변경 메뉴
		boolean roof = false; // 루프
		boolean chnRoof = false; // 정보변경루프

		String chkName = ""; // 이름확인
		String chnPhoneNum; // 연락처 변경
		String chnAddress; // 주소록 변경

		while (!roof) { // true가 되면 좋료

			System.out.println("1.회원가입 ");
			System.out.println("2.회원검색 ");
			System.out.println("3.정보수정 ");
			System.out.println("4.회원탈퇴 ");
			System.out.println("5.전체목록 ");
			System.out.println("0.프로그램종료 ");

			System.out.print("메뉴선택 : ");

			menu = System.in.read() - 48;
			System.in.read();
			System.in.read(); // 숫자입력 엔터처리
			System.out.println();

			if (menu == 1) { // 회원가입

				System.out.println();
				System.out.print("이름 : ");
				name = br.readLine();
				System.out.print("나이 : ");
				age = Integer.parseInt(br.readLine());
				System.out.print("전화 : ");
				phoneNum = br.readLine();
				System.out.print("주소 : ");
				address = br.readLine();

				member.add(new MyMember(name, age, phoneNum, address)); // 벡터 멤버에 저장

				System.out.println("성공적으로 가입하였습니다.");
				System.out.println();

			} // 1 if end

			if (menu == 2) { // 회원검색

				System.out.print("찾으시는 회원 이름 : ");
				chkName = br.readLine();

				for (int i = 0; i < member.size(); i++) {

					MyMember members = (MyMember) member.elementAt(i);

					if (chkName.equals(members.getName())) {

						System.out.println("검색에 성공하였습니다.");
						System.out.println();

						chnRoof = true; // 정보변경을 허가한다.

					} // 이름 맞는 if end

				} // 찾는 for end

			} // 2 if end

			if (menu == 3) {

				if (chnRoof != true) {

					System.out.println("검색을 먼저 수행하셔야 합니다.");
					System.out.println();
					continue;

				} else {

					do {

						System.out.println("1.연락처수정 ");
						System.out.println("2.주소록수정 ");
						System.out.println("0.수정취소 ");

						System.out.print("메뉴선택 : ");

						chnMenu = System.in.read() - 48;
						System.in.read();
						System.in.read(); // 숫자입력 엔터처리
						System.out.println();

						if (chnMenu == 1) { // 연락처수정

							System.out.println(chkName + "의 연락처정보를 수정합니다. ");
							System.out.print("수정할 번호 : ");

							chnPhoneNum = br.readLine();

							for (int i = 0; i < member.size(); i++) {

								MyMember members = (MyMember) member.elementAt(i);

								if (chkName.equals(members.getName())) {

									members.setPhoneNum(chnPhoneNum);

								}

							}
							System.out.println("전화번호가 성공적으로 변경되었습니다.");
							System.out.println();
							break;

						} else if (chnMenu == 2) { // 주소록수정

							System.out.println(chkName + "의 주소록정보를 수정합니다. ");
							System.out.print("수정할 주소 : ");

							chnAddress = br.readLine();

							for (int i = 0; i < member.size(); i++) {

								MyMember members = (MyMember) member.elementAt(i);

								if (chkName.equals(members.getName())) {

									members.setAddress(chnAddress);

								}

							}
							System.out.println("주소가 성공적으로 변경되었습니다.");
							System.out.println();
							break;

						} else if (chnMenu == 0) { // 수정취소
							System.out.println(chkName + "님의 수정을 취소하였습니다.");
							System.out.println();
							break;
						}

					} while (chnMenu != 1 || chnMenu != 2 || chnMenu != 0);

				}

			}
			if (menu == 4) { // 해당이름 회원탈퇴

				if (chnRoof != true) {

					System.out.println("검색을 먼저 수행하셔야 합니다.");
					System.out.println();
					continue;

				} else {

					for (int n = 0; n < member.size(); n++) {

						MyMember members = (MyMember) member.elementAt(n);

						if (chkName.equals(members.getName())) {

							System.out.print(chkName + "의 정보를 삭제 하시겠습니까? (y/n) : ");
							char ans = (char) System.in.read();
							System.in.read();
							System.in.read();

							if (ans == 'y' || ans == 'Y') {

								member.removeElementAt(n); // 벡터에서 삭제
								System.out.println("성공적으로 회원탈퇴 되었습니다.");
								System.out.println();
								chnRoof = false;
								chkName = "";

							}

						}

						menu = -1;

					}

				}

			} // 탈퇴 if end

			if (menu == 5) { // 전체목록출력

				for (int z = 0; z < member.size(); z++) {

					System.out.println();
					MyMember members = (MyMember) member.elementAt(z); // i번째 멈버 출력
					System.out.println((z + 1) + "번 회원정보");
					System.out.println("이름 : " + members.getName());
					System.out.println("나이 : " + members.getAge());
					System.out.println("전화 : " + members.getPhoneNum());
					System.out.println("주소 : " + members.getAddress());
					System.out.println();

				}

			} // 전체목록출력 end

			if (menu == 0) { // 프로그램종료

				System.out.print("종료? : (y/n)");

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
