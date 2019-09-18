package factories;

import humans.Hero;
import humans.*;

public class HumanFactory implements AbstractFactory<Human.HumanCreator>{

	@Override
	public Human.HumanCreator create(String type) {
		if("Hero".equalsIgnoreCase(type)) {
			return new Hero();
		}
		return null;
	}

}
