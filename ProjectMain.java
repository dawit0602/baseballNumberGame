package myproject;

import java.util.Arrays;
import java.util.Scanner;

public class ProjectMain {
    public static void main(String[] args) {
        ProjectDB proDB = ProjectDB.getInstance();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 일반모드 | 2. 내 기록 | 3. 나가기");
            System.out.print(">>> ");

            String command1 = scan.nextLine();

            if (command1.equals("1")) {
                System.out.println("                        (m)메뉴화면");
                System.out.println("START");
                System.out.print(">>> ");

                int[] getWinNum = new int[4];
                int idx = 0;

                while (idx < 4) {
                    int random = (int) (Math.random() * 9) + 1;
                    boolean isDuple = false;

                    for (int i = 0; i < getWinNum.length; i++) {
                        if (getWinNum[i] == random) {
                            isDuple = true;
                            break;
                        }
                    }

                    if (!isDuple) {
                        getWinNum[idx] = random;
                        idx++;
                    }
                }

                int tryNum = 0;

                while (true) {
                    System.out.println("네 자리 숫자를 입력해주세요 (m: 일시정지):");
                    String input = scan.nextLine();

                    // 메뉴 화면 처리
                    if (input.equalsIgnoreCase("m")) {
                        boolean menuExit = false; // 플래그 변수

                        while (true) {
                            System.out.println("게임을 종료하시겠습니까? (y/n)");
                            String confirm = scan.nextLine();

                            if (confirm.equalsIgnoreCase("y")) {
                                System.out.println("게임을 종료하였습니다. 메뉴화면으로 돌아갑니다.");
                                return;
                            } else if (confirm.equalsIgnoreCase("n")) {
                                System.out.println("게임을 계속 진행합니다.");
                                menuExit = true;
                                break;
                            } else {
                                System.out.println("잘못된 입력입니다. y 또는 n을 입력해주세요.");
                            }
                        }

                        if (menuExit) {
                            continue;
                        }
                    }

                    int intNum;
                    try {
                        intNum = Integer.parseInt(input);

                        if (input.length() != 4) {
                            System.out.println("네 자리 숫자를 정확히 입력해주세요.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                        continue;
                    }

                    int[] getNum = new int[4];
                    for (int i = 0; i < input.length(); i++) {
                        getNum[i] = Character.getNumericValue(input.charAt(i));
                    }

                    tryNum++;
                    System.out.println(Arrays.toString(getNum));
                    System.out.println("시도 횟수: " + tryNum);

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
                        System.out.println("정답!!");
                        System.out.println("총 시도횟수: " + tryNum);

                        System.out.println("기록을 등록하시겠습니까? (Y/N)");
                        String command2 = scan.nextLine();

                        if (command2.equalsIgnoreCase("Y")) {
                            while (true) {
                                System.out.println("이름을 입력해주세요");
                                System.out.print(">>> ");
                                String inputName = scan.nextLine();

                                Project bro = new Project(0, inputName, tryNum);

                                boolean isGood = proDB.proRecord(bro);
                                proDB.plusPro(bro);

                                if (isGood) {
                                    break;
                                }
                            }
                            break;
                        } else {
                            System.out.println("기록을 입력하지 않았습니다.");
                            break;
                        }
                    }
                }
            } else if (command1.equals("2")) {
                System.out.println("STAND\tNAME\tTRY NUMBER");
                proDB.showRecList();
            } else if (command1.equals("3")) {
                System.out.println("이용해주셔서 감사합니다.");
                break;
            } else {
                System.out.println("올바른 명령을 입력해주세요.");
            }
        }

        scan.close();
    }
}
