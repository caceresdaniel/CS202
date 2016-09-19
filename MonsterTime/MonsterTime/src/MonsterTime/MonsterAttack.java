package MonsterTime;

public class MonsterAttack {
	private int attackId;
	private int attackDay;
	private int attackMonth;
	private int attackYear;
	private int attackVictims;
	private String monsterName;
	private String attackLocation;
	private String fullDate;

	public MonsterAttack(String fullDateIn, int attackIdIn, int attackVictimsIn, String monsterNameIn,
			String attackLocationIn) {

		attackId = attackIdIn;
		attackVictims = attackVictimsIn;
		monsterName = monsterNameIn;
		attackLocation = attackLocationIn;
		fullDate = fullDateIn;
	}

	public String getFullDate() {
		return fullDate;
	}

	public void setFullDate(String fullDate) {
		this.fullDate = fullDate;
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

	public void fullDateSplitter(String fullDate) {

		String[] afterSplit = fullDate.split("/");

		attackDay = Integer.parseInt(afterSplit[0]);
		attackMonth = Integer.parseInt(afterSplit[1]);
		attackYear = Integer.parseInt(afterSplit[2]);

	}

	public String toString() {

		fullDateSplitter(fullDate);

		return "Attack # " + attackId + " occured on " + attackDay + "/" + attackMonth + "/" + attackYear + ". "
				+ monsterName + " attacked " + attackLocation + ", resulting in " + attackVictims
				+ " tragic fatalities." + "\n";

	}
}
