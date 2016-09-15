package MonsterTime;

public class MonsterAttack {
	private int attackId;
	private int attackDay;
	private int attackMonth;
	private int attackYear;
	private int attackVictims;
	private String monsterName;
	private String attackLocation;

	public MonsterAttack(int attackIdIn, int attackDayIn, int attackMonthIn, int attackYearIn, int attackVictimsIn,
			String monsterNameIn, String attackLocationIn) {
		attackId = attackIdIn;
		attackDay = attackDayIn;
		attackMonth = attackMonthIn;
		attackYear = attackYearIn;
		attackVictims = attackVictimsIn;
		monsterName = monsterNameIn;
		attackLocation = attackLocationIn;
	}

	public int getAttackId() {
		return attackId;
	}

	public void setAttackId(int attackId) {
		this.attackId = attackId;
	}

	public int getAttackDay() {
		return attackDay;
	}

	public void setAttackDay(int attackDay) {
		this.attackDay = attackDay;
	}

	public int getAttackMonth() {
		return attackMonth;
	}

	public void setAttackMonth(int attackMonth) {
		this.attackMonth = attackMonth;
	}

	public int getAttackYear() {
		return attackYear;
	}

	public void setAttackYear(int attackYear) {
		this.attackYear = attackYear;
	}

	public int getAttackVictims() {
		return attackVictims;
	}

	public void setAttackVictims(int attackVictims) {
		this.attackVictims = attackVictims;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getAttackLocation() {
		return attackLocation;
	}

	public void setAttackLocation(String attackLocation) {
		this.attackLocation = attackLocation;
	}

	public String toString() {
		return "Attack # " + attackId + " occured on " + attackDay + "/" + attackMonth + "/" + attackYear + ". "
				+ monsterName + " attacked " + attackLocation + ", resulting in " + attackVictims
				+ " tragic fatalities.";

	}

	public void fullDateSplitter(String fullDate) {

		String[] afterSplit = fullDate.split("/");

		Integer.parseInt(afterSplit[0], attackDay);
		Integer.parseInt(afterSplit[1], attackMonth);
		Integer.parseInt(afterSplit[2], attackYear);

	}
}
