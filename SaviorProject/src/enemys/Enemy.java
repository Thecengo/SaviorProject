package enemys;

public interface Enemy {
	
	
	class EnemyCreator{
		public int hp;
	    public int attact;
	    public int positon;
		
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

		public int getPositon() {
			return positon;
		}

		public void setPositon(int positon) {
			this.positon = positon;
		}

	}

}
