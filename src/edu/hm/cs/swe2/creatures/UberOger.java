package edu.hm.cs.swe2.creatures;

public class UberOger extends Oger {

	public final static int maxLifePoint = 10;

	public UberOger() {
		super();

	}

	// public void attack(Creature other) {
	// if (this.isAlive() && other.isAlive() && other.getName() != "Oger"
	// && other.lifePoint < 2) {
	// other.damage();
	// }
	//
	// }

	@Override
	public void damage() {

		if (lifePoint > 1) {
			super.damage();
		}
	}

	@Override
	public void heal() {
		lifePoint = maxLifePoint;

	}

}