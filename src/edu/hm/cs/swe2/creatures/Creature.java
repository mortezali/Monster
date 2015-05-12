package edu.hm.cs.swe2.creatures;


public abstract class Creature {
	private int lifePoint;
	private final int maxLifePoint;
	private final String name;

	public Creature(String name, int lifePoint, int maxLifePoint) {

		this.name = name;
		this.lifePoint = lifePoint;
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

	protected boolean isAlive() {

		if (this.lifePoint > 0) {
			return true;
		}

		else {
			return false;

		}
	}

	public int heal(Creature creature) {

		if (this.getLifePoint() < this.maxLifePoint) {
			this.lifePoint = this.lifePoint + 1;
		}
		if (this.getLifePoint() == 0) {
			this.lifePoint = this.lifePoint - 1;
		}
		return this.lifePoint;
	}


	public void damage(Creature other) {

		if (this.isAlive() && other.isAlive()
				&& this.getLifePoint() > other.getLifePoint())
			other.getLifePoint(other.getLifePoint() - this.getLifePoint());

		else if (this.isAlive() && other.isAlive()
				&& other.getLifePoint() > this.getLifePoint())
			this.getLifePoint(this.getLifePoint() - other.getLifePoint());

		else {

		}
	
	

	//public  void attack(Creature other);



		
	}
}
