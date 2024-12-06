package myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProjectMain {
	public static void main(String[] args) {
		// 1. 설계
		// 무엇을 만들지 정해놔야

		// 어떤걸 만들지 작성

		// 만들때 필요한 객체 생각
		// 객체에 대한 클래스 생성

		// 실행 화면(콘솔창)에 대한 생각

		// 미니게임천국?
		// 숫자 야구
		// 랜덤한 4자리 숫자 출력
		// 시도 횟수
		// 같은 자리 수인지 체크를 어떻게?
		// 다 따로따로 자릿수 넣은다음에
		// 중복체크?
		// 시도 횟수에 따른 랭킹 남기기

		ProjectDB proDB = ProjectDB.getInstance();

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 일반모드 | 2. 내 기록 | 3. 나가기");
			System.out.print(">>> ");

			String command1 = scan.nextLine();
			if (command1.equals("1")) {

				System.out.println("START");
				System.out.println(">>> ");
				
				// getWinNum 배열 안에 중복되지 않는 무작위 4가지 숫자를 넣는다.
				int[] getWinNum = new int[4];

				int idx = 0;

				while (idx < 4) {
					int random = (int) (Math.random() * 9) + 1;

					boolean isDuple = false;

					for (int i = 0; i < getWinNum.length; i++) {
						if (getWinNum[i] == random) {
							isDuple = true;
						}
					}

					if (isDuple == false) {
						getWinNum[idx] = random;
						idx++;
					}
				}

				int tryNum = 0;

				while (true) {
					String input = scan.nextLine();
					
					int intNum = Integer.parseInt(input);
					String inNum = Integer.toString(intNum);

					int[] getNum = new int[4];
					for (int i = 0; i < inNum.length(); i++) {
						String inputNum = inNum.substring(i, i + 1);
						int getIntNum = Integer.parseInt(inputNum);
						if (!(input.length() == 4)) {
							System.out.println("네 자리 숫자를 정확히 입력해주세요");
							continue;
						}
						getNum[i] = getIntNum;
					}
					tryNum++;
					System.out.println(Arrays.toString(getNum));
					System.out.println("시도 횟수: " + tryNum);

					// win과 num이 자릿수 + 숫자까지 같으면 str+
					// win과 num이 자릿수는 틀린데 숫자만 같으면 ball+

					int str = 0;
					int ball = 0;
					for (int j = 0; j < getWinNum.length; j++) {
						for (int k = 0; k < getNum.length; k++) {
							if (getWinNum[j] == getNum[k]) {
								if (j == k) {
									str++;
								} else {
									ball++;
								}
							}
						}
					}
					System.out.println(str + " Strike, " + ball + " Ball");

					if (str == 4) {
						System.out.println("\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⡤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢂⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⢿⡽⣽⢝⣞⣽⡢⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⠄⠀⠀⠀⠀⠀⢀⠁⡘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⡽⣯⢯⢯⣞⣞⢾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡈⢂⠀⠄⠀⠀⠄⡢⠂⢀⠂⠀⠔⠀⠀⡀⠂⠁⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⢀⢔⢔⡕⣕⢿⣾⣿⣫⣗⢷⢽⢵⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠢⢀⠈⡠⢐⠬⠢⠣⠥⠥⣄⠡⡀⢊⠠⢐⠈⡀⠄⠒⠁⠀⠀\r\n"
								+ "⠀⠀⠀⠀⡸⣜⢮⢮⡪⠳⣗⠩⡯⠙⣟⢏⠓⠯⠀⠀⠀⠀⠁⠁⠆⡀⠄⡀⠀⡦⢋⢀⡀⠀⠀⠀⠀⠀⠑⢔⠡⢐⠡⠐⡈⢀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⢯⣮⣻⠣⢨⠑⣊⠯⠆⡵⣣⡣⡧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠁⡂⡱⠉⠁⠁⠐⠰⢀⠀⠀⠀⠠⠈⢦⠒⠉⢅⣁⡂⡱⡀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⢫⢷⣳⢷⣌⢌⣢⢂⠓⡢⣨⣜⡉⡅⠔⢔⠠⡀⠄⡔⣂⣁⡁⡢⡇⠀⠀⠀⠀⠀⠀⠉⠒⠔⠄⡆⠺⡤⣱⡴⣶⢞⠗⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠐⣕⡳⣫⢮⡪⡝⡽⡓⡟⣽⢣⢔⡇⡅⡇⣪⠊⡌⠆⠇⠂⣈⠄⣇⠀⠀⠀⠀⢀⠀⠄⠂⠠⢁⠐⣸⠠⠠⠐⠈⠀⠂⠐⠀⠄\r\n"
								+ "⠀⠀⠀⠀⠀⡟⡮⣮⣫⢯⢯⡏⣮⢾⢳⠡⢂⠌⣪⡨⠞⠗⠓⠑⠉⢀⠔⢁⠘⢄⢀⠡⢁⠂⠔⠠⠁⠅⠂⡰⢑⠔⠠⡀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⢰⡻⣪⢳⣳⣫⣳⣝⢧⡻⡄⠑⠒⠊⠁⠀⠀⠀⠀⢀⠔⠅⠀⠁⣀⠕⠑⡦⣐⣨⣠⣡⡣⢕⠛⠈⠂⠐⡀⡈⠈⠐⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⡳⢽⣼⡮⣾⢮⣇⢾⢺⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠀⢂⠅⢀⠄⢸⠐⢀⠒⡈⡐⡑⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⣽⢙⢛⠅⣟⠵⢯⢏⡧⠨⠒⢄⠀⠀⠀⠀⠀⠀⠀⠀⢀⠒⠀⠌⠀⠀⠠⠂⢘⠄⠐⠐⡀⠀⠀⢑⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⣻⡱⢔⠨⠠⡙⡪⣾⠬⠸⡈⡢⢑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠠⠁⠀⠀⠀⠀⠰⠀⠀⠐⢂⠀⠀⠀⠑⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⠸⣎⠆⠅⢕⠐⠬⠈⠳⣅⢂⠢⠡⢂⢅⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⠀⠡⣣⡱⡐⡱⠱⠀⠀⠀⠑⠧⣕⢁⢆⡥⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⢀⢀⡹⡨⢂⢺⠃⠀⠀⠀⠀⠀⠘⡗⡢⠩⢂⠕⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⣠⠦⢓⢑⠼⠲⣴⡵⠊⠀⠀⠀⠀⠀⠀⠀⠙⢦⡡⣡⢊⠳⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⢠⣧⣪⠢⠡⡡⣳⠕⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠻⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠔⠽⠿⠖⡡⠕⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "");
						System.out.println("정답!!");
						System.out.println("총 시도횟수: " + tryNum);

						System.out.println("기록을 등록하시겠습니까?  (Y/N)");
						String command2 = scan.nextLine();
						if (command2.equals("Y")) {
							while(true) {								
								System.out.println("이름을 입력해주세요");
								System.out.println(">>> ");
								String inputName = scan.nextLine();
								
								Project bro = new Project(0, inputName, tryNum);
								
								boolean isGood = proDB.proRecord(bro);
								proDB.plusPro(bro);
								
								if(isGood) {
									break;
								}
							}
							
							break;
						} else {
							System.out.println("기록을 입력하지 않았습니다.");
							break;
						}

					} else {
						continue;
					}
				}
			} else if (command1.equals("2")) {

				System.out.println("STAND	NAME	TRY NUMBER");
				proDB.showRecList();
			} else if (command1.equals("3")) {
				System.out.println("이용해주셔서 감사합니다.");
				break;

			} else {
				continue;
			}
		}
	}

}
