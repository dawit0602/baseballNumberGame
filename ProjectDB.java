package myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import ch09_class.homepage.Board;

public class ProjectDB {
	private ArrayList<Project> recList = new ArrayList<>();

	public void plusPro(Project pro) {
		pro.setProRecord(recList.size());
}
	private ProjectDB() {
	}
	
	private static ProjectDB instance = new ProjectDB();

	public static ProjectDB getInstance() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	
	public void showRecList() {
		for(int i = 0; i < recList.size(); i++) {
			Project pro = recList.get(i);
			System.out.println(pro.getProRecord() + "번째	"+ pro.getMemName() +"	   "+ pro.getTryNum() + "회");
			if(recList.isEmpty()) {
				System.out.println("등록된 기록이 없습니다.");
			}
		}
		
	}
	
	// 중복된게 있다면 false 리턴, 중복되지 않아서 등록이 잘 되었다면 true 리턴
	public boolean proRecord(Project pro) {
		boolean isDuple = false;
		for (int i = 0; i < recList.size(); i++) {
			if (recList.get(i).getMemName().equals(pro.getMemName())) {
				isDuple = true;
			}
		}
		
		if(isDuple) {
			System.out.println("중복되는 닉네임입니다.");
			return false;
		}else {
			System.out.println("랭킹에 등록되었습니다.");
			recList.add(pro);
			return true;
		}
	}
	
	

	
	
	
	
	

}
