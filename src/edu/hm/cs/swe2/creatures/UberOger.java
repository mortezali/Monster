package edu.hm.cs.swe2.creatures;

public class UberOger extends Creature{
	
	 
	
	private static int lifePoint = 5;
	public final static int maxLifePoint = 10;

	public UberOger() {
		super("Oger", maxLifePoint);
		
	}
	
	public void attack(Creature other) {
		if (this.isAlive() && other.isAlive() && other.getName() != "Oger" && other.lifePoint < 2){
			other.damage();
		}
			
	
	}
	
	public void damage() {

		if (this.isAlive()) {
			UberOger.lifePoint = UberOger.lifePoint - 1;
		}
	}
	@Override
	public int getInitialLivePoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getLifepoint() {
		return lifePoint;
	}

}