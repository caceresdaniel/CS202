package MonsterTime;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class BinaryMonsterPersister implements MonsterPersister {

	@Override
	public void saveToFile(File file, List<MonsterAttack> monsterAttacks) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			out.writeObject(monsterAttacks);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	@Override
	public List<MonsterAttack> readFromFile(File file) {
		ObjectInputStream in = null;
		List<MonsterAttack> monsterAttacks = null;
		
		try{
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			monsterAttacks = (List<MonsterAttack>)in.readObject();
			in.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return monsterAttacks;
	}

}
