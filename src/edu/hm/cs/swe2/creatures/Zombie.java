package edu.hm.cs.swe2.creatures;

public class Zombie extends Creature {

	public Zombie(String name, int maxLifePoint) {
		super(name, maxLifePoint);

	}

	private String name = "";
	private boolean alreadyDamaged;
	private final static int maxLifePoint = 0;

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
