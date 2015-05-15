package edu.hm.cs.swe2.creatures;

public class Zombie extends Creature {
	
	
	private final static int maxLifePoint = 0;

	public Zombie() {
		super("", maxLifePoint);

	}



	@Override
	public void attack(Creature other) {

		if (this.isAlive() && other.isAlive() && this != other) {
			other.damage();
			other.damage();
		}

	}

	@Override
	public int getInitialLivePoints() {
		return 0;
	}

}
