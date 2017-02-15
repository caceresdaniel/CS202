package MonsterTime;

import java.io.File;
import java.util.List;

public interface MonsterPersister {
	
	public void saveToFile(File file, List<MonsterAttack> monsterAttacks);
	
	public List<MonsterAttack> readFromFile(File file);
	
}
