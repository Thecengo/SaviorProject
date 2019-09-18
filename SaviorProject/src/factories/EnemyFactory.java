package factories;

import enemys.Enemy;
import enemys.Enemy.EnemyCreator;
import enemys.*;

public class EnemyFactory implements AbstractFactory<Enemy.EnemyCreator> {

	@Override
	public EnemyCreator create(String type) {
		
		if("Bug".equalsIgnoreCase(type)) {
			return new Bug();
		}
		else if("Lion".equalsIgnoreCase(type)) {
			return new Lion();
		}
		else if("Zombie".equalsIgnoreCase(type)) {
			return new Zombie();
		}
		else if("ZombieDog".equalsIgnoreCase(type)) {
			return new ZombieDog();
		}
		else if("Mutant".equalsIgnoreCase(type)) {
			return new Mutant();
		}
		return null;
	}
	
	

}
