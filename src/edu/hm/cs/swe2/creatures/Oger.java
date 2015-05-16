package edu.hm.cs.swe2.creatures;

public class Oger extends Creature{
	
	 
		public final static int maxLifePoint = 10;

		public Oger() {
			super("Oger", maxLifePoint);

		}

		public void attack(Creature other) {
			while(other.lifePoint > 1){			
			if (this.isAlive() && other.isAlive() && other.getName() != "Oger" && other.lifePoint > 2){
			
				other.damage();
			}
			}
		
		}
		@Override
		public int getInitialLivePoints() {

			return this.maxLifePoint / 2;
		}

}
