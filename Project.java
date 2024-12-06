package myproject;

public class Project {
	// 담겨져야할거 등수, 닉네임, 시도 횟수
	private int proRecord;
	private String memName;
	private int tryNum;

	public Project() {
	}

	public Project(int proRecord, String memName, int tryNum) {
		this.proRecord = proRecord;
		this.memName = memName;
		this.tryNum = tryNum;
	}

	@Override
	public String toString() {
		return "Project [proRecord=" + proRecord + ", memName=" + memName + ", tryNum=" + tryNum + "]";
	}

	public int getProRecord() {
		return proRecord;
	}

	public void setProRecord(int proRecord) {
		this.proRecord = proRecord;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getTryNum() {
		return tryNum;
	}

	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}

	

	

	

	

	
	



}
