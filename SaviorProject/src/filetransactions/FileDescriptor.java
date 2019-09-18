package filetransactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import enemys.Enemy;
import enemys.Enemy.EnemyCreator;
import factories.FactoryProvider;
import humans.Hero;
import resources.Resources;

public class FileDescriptor {
	class SortByPosition implements Comparator<Enemy.EnemyCreator>{

		@Override
		public int compare(EnemyCreator arg0, EnemyCreator arg1) {
			return arg0.getPositon() - arg1.getPositon();
		}
		
	}
	public List<String> entityNames = new ArrayList<>();
	Resources resource;
	public List<Enemy.EnemyCreator> enemyList = new ArrayList<>();
	List<String> seperatedByTherePositionStringList = new ArrayList<String>();
	HashMap<String, Integer> seperatedByHasAndHpMap = new HashMap<String, Integer>();
	HashMap<String, Integer> seperatedByAttackMap = new HashMap<String, Integer>();
	public static int counter;
	public Hero hero;

	public FileDescriptor() {
	
	}

	public void makeEntity(HashMap<Integer, String[]> splittedBySpaceList) {
		ArrayList<String> tempArrayList = new ArrayList<>();
		for (int i = 0; i < splittedBySpaceList.size(); i++) {
			for (String word : splittedBySpaceList.get(i)) {
				if (isStartWithUpperCase(word) && !"There".equals(word) && !"Enemy".equals(word)) {
					tempArrayList.add(word);
				}
			}

		}
		entityNames = tempArrayList;	
	}

	public void assignAllValues(HashMap<Integer, String> allWordList) {
		hero = (Hero) FactoryProvider.getFactory("").create("Hero");
		thereListAdd(allWordList);
		hasAndHpListAdd(allWordList);
		attackListAdd(allWordList);
		assignHpValues( seperatedByHasAndHpMap );
		assignAttackValues( seperatedByAttackMap );
		Collections.sort(enemyList,new SortByPosition());
	}


	public boolean isStartWithUpperCase(String word) {
		if (word == null)
			return false;
		else
			return Character.isUpperCase(word.codePointAt(0));
	}

	public void thereListAdd(HashMap<Integer, String> allWordList) {
		for (Map.Entry<Integer, String> entry : allWordList.entrySet()) {
			if (entry.getValue().contains("There")) {
				Enemy.EnemyCreator tempEnemy = (EnemyCreator) FactoryProvider.getFactory("enemy")
						.create(entityNames.get(entry.getKey()));
				int tempPosition = Integer.parseInt(entry.getValue().replaceAll("\\D+", ""));
				enemyList.add(tempEnemy);
				enemyList.get(counter).setPositon(tempPosition);
				seperatedByTherePositionStringList.add(entityNames.get(entry.getKey()));
				counter++;
			}
		}
	}

	public void hasAndHpListAdd(HashMap<Integer, String> allWordList) {

		for (Map.Entry<Integer, String> entry : allWordList.entrySet()) {
			if (entry.getValue().contains("has") && entry.getValue().contains("hp")) {
				int tempHp = Integer.parseInt(entry.getValue().replaceAll("\\D+", ""));
				seperatedByHasAndHpMap.put(entityNames.get(entry.getKey()), tempHp);

			}
		}

	}

	public void attackListAdd(HashMap<Integer, String> allWordList) {
		for (Map.Entry<Integer, String> entry : allWordList.entrySet()) {
			if (entry.getValue().contains("attack")) {
				int tempHp = Integer.parseInt(entry.getValue().replaceAll("\\D+", ""));
				seperatedByAttackMap.put(entityNames.get(entry.getKey()), tempHp);

			}
		}
	}

	public void assignHpValues(HashMap<String, Integer> allWordList) {

		for (int i = 0; i < seperatedByTherePositionStringList.size(); i++) {
			for (Map.Entry<String, Integer> entry : allWordList.entrySet()) {
				if (entry.getKey().equals(seperatedByTherePositionStringList.get(i))) {
					enemyList.get(i).setHp(entry.getValue());
				}
				else if(entry.getKey().equals("Hero")) {
					hero.setHp(entry.getValue());
				}
			}

		}

	}

	public void assignAttackValues(HashMap<String, Integer> attactList) {
		for (int i = 0; i < seperatedByTherePositionStringList.size(); i++) {
			for (Map.Entry<String, Integer> entry : attactList.entrySet()) {
				if (entry.getKey().equals(seperatedByTherePositionStringList.get(i))) {
					enemyList.get(i).setAttact(entry.getValue());
				}
				else if(entry.getKey().equals("Hero"))
					hero.setAttact(entry.getValue());
				
			}

		}
	}
	public void resourceAssign() {
		
	}

}
