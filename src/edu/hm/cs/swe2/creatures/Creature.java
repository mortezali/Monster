package edu.hm.cs.swe2.creatures;

public abstract class Creature {
	protected int lifePoint;
	private final int maxLifePoint;
	private final String name;

	public Creature(String name, int maxLifePoint) {

		this.name = name;
		this.lifePoint = getInitialLivePoints();
		this.maxLifePoint = maxLifePoint;

	}

	public String getName() {
		return name;
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public int maxLifePoint() {
		return maxLifePoint;
	}

	public boolean isAlive() {

		if (this.lifePoint > 0) {
			return true;
		}

		return false;

	}

	public void heal() {

		if (this.isAlive() && this.getLifePoint() < this.maxLifePoint) {
			this.lifePoint = this.lifePoint + 1;
			{
				if (this.getLifePoint() == 0) {

				}
			}
		}

	}

	public int getHealth() {
		return this.lifePoint;
	}

	public void damage() {

		if (this.isAlive()) {
			this.lifePoint = this.lifePoint - 1;
		}
	}

	public void attack(Creature other) {

		if (this.isAlive() && other.isAlive() && this != other) {
			other.damage();

		}

	}

	public abstract int getInitialLivePoints();

}
