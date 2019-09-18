package factories;

public class FactoryProvider {
	
	public static AbstractFactory<?> getFactory(String choise) {
		if("enemy".equalsIgnoreCase(choise)) {
			return new EnemyFactory();
		}
		else
			return new HumanFactory();
		
	
	}

}
