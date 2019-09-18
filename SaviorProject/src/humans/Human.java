package humans;

public interface Human {
	
	class HumanCreator{
		private int hp;
		private int attact;
		private int position;
		
		public HumanCreator() {
			
		}
		
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
		public int getAttact() {
			return attact;
		}
		public void setAttact(int attact) {
			this.attact = attact;
		}
		public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
	}

}
