package journey;
import java.util.ArrayList;

import filetransactions.FileDescriptor;


public class Journey {

	public ArrayList<String> writeToFileStringList = new ArrayList<>();

	int heroRemainingHp;
	boolean isSurvived = true;
	int lastPosition = 0;
	
	public void startJourney(FileDescriptor fileDescriptor) {
		
		
		System.out.println("Hero started Journey with " + fileDescriptor.hero.getHp() + " HP!");
		String start = "Hero started Journey with "+ fileDescriptor.hero.getHp() + " HP!";
		writeToFileStringList.add(start);
	
		firstMatch(fileDescriptor);
		
		for(int i = 1;i < fileDescriptor.enemyList.size();i++) {
			
			if(heroRemainingHp > fileDescriptor.enemyList.get(i).getHp()) {
				int tempEnemyHp = fileDescriptor.enemyList.get(i).getHp();
				int tempHeroAttack = fileDescriptor.hero.getAttact();
				int tempEnemyAttack = fileDescriptor.enemyList.get(i).getAttact();
				String getClassName =fileDescriptor.enemyList.get(i).getClass().getSimpleName();
				int tempNumberOfAttack = numberOfAttacksToEnemy(tempEnemyHp,heroRemainingHp,tempHeroAttack);

				heroRemainingHp = heroRemainingHp - herosDamage(tempNumberOfAttack,tempEnemyAttack);
				String str = "Hero defated "+getClassName+" with "+heroRemainingHp+" HP remaining";
				writeToFileStringList.add(str);
				System.out.println(str);
				isSurvived = true;
			}
			else {
				int tempEnemyHp = fileDescriptor.enemyList.get(i).getHp();
				int tempHeroAttack = fileDescriptor.hero.getAttact();
				int tempEnemyAttack = fileDescriptor.enemyList.get(i).getAttact();
				int tempSaldiriAdedi = attactToWhenPowerThenHero(heroRemainingHp, tempEnemyHp,tempEnemyAttack);
				String getClassName =fileDescriptor.enemyList.get(i).getClass().getSimpleName();
				int enemyRemainingHp = tempEnemyHp - enemysDamage(tempSaldiriAdedi,tempHeroAttack);
				
				String str = getClassName +" defeated Hero with  "+enemyRemainingHp +" HP remaining";
				writeToFileStringList.add(str);
				lastPosition = fileDescriptor.enemyList.get(i).getPositon();
				System.out.println(str);
				isSurvived = false;
				break;
			}
		}
		String deadOrSurvivedString =  surviveOrDeadString(isSurvived,lastPosition);
		writeToFileStringList.add(deadOrSurvivedString);
		System.out.println(deadOrSurvivedString);
		

	}
	
	public  int numberOfAttacksToEnemy(int enemyHp, int heroHp,int heroAttack) {
		if( enemyHp % heroAttack != 0) {
			int fullDividedComplement = heroAttack - (enemyHp % heroAttack ) + enemyHp;
			int tempSayi = fullDividedComplement / heroAttack;
			return tempSayi;
			
		}
		else {
			int tempSayi = enemyHp / heroAttack;
			return tempSayi;
				
		}
		
	}
	
	public int herosDamage(int numberOfHeroAttack, int enemyAttack ) {
		return numberOfHeroAttack * enemyAttack;	
		
	}
	
	public int enemysDamage(int numberOfEnemyAttack, int heroAttack) {
		return numberOfEnemyAttack * heroAttack;
	}
		
	
	public  int attactToWhenPowerThenHero(int heroHp, int enemyHp, int enemyAttack) {
		if(heroHp % enemyAttack != 0) {
			int fullDividedComplement = enemyAttack - ( heroHp % enemyAttack ) + heroHp;
			int tempNum = fullDividedComplement / enemyAttack;
			return tempNum;
			
		}
		else {
			int tempNum = heroHp / enemyAttack;
			return tempNum;
		}
	}
	public String surviveOrDeadString(boolean isSurvived,int lastPosition) {
		if(isSurvived) {
			return "Hero Survived!";
		}
		else {
			return "Hero is Dead!! Last seen at position " + lastPosition + "!!";
		}
	}
	
	public void firstMatch(FileDescriptor fileDescriptor) {
		if(fileDescriptor.hero.getHp() > fileDescriptor.enemyList.get(0).getHp()) {
			int tempHeroHp = fileDescriptor.hero.getHp();
			int tempEnemyHp = fileDescriptor.enemyList.get(0).getHp();
			int tempHeroAttack = fileDescriptor.hero.getAttact();
			int tempEnemyAttack = fileDescriptor.enemyList.get(0).getAttact();
			String getClassName =fileDescriptor.enemyList.get(0).getClass().getSimpleName();
			
			int tempNumberOfAttack = numberOfAttacksToEnemy(tempEnemyHp, tempHeroHp, tempHeroAttack);
			heroRemainingHp = tempHeroHp - herosDamage(tempNumberOfAttack, tempEnemyAttack);
			String str = "Hero defated "+ getClassName + " with " + heroRemainingHp + " HP remaining";
			writeToFileStringList.add(str);
			System.out.println(str);
			isSurvived = true;
		}
		else {
			int tempEnemyHp = fileDescriptor.enemyList.get(0).getHp();
			int tempHeroAttack = fileDescriptor.hero.getAttact();
			int tempEnemyAttack = fileDescriptor.enemyList.get(0).getAttact();
			String getClassName =fileDescriptor.enemyList.get(0).getClass().getSimpleName();
			int tempNumberOfAttack = attactToWhenPowerThenHero(heroRemainingHp, tempEnemyHp,tempEnemyAttack);
			
			int enemyKalanHp = tempEnemyHp -enemysDamage(tempNumberOfAttack, tempHeroAttack);
			String str = getClassName + " defeated Hero with" + enemyKalanHp +" HP remaining";
			writeToFileStringList.add(str);
			System.out.println(str);
			isSurvived = false;
		
		}
	}

}
