package edu.hm.cs.swe2.creatures;

public class Robot extends Creature {

	private final static int maxLifePoint = 6;
	private int RobotDamageCounter = 0;

	// TODO: Der Parameter vom Konstruktor ist ein INT
	// In der Creature Panel kannst du das sehen.
	// TODO: name wird in Creature gespeichert. nicht hier.

	public Robot(int RobotCounter) {
		super(null, maxLifePoint);

	}

	public void damage() {
		RobotDamageCounter++;
		if (RobotDamageCounter == maxLifePoint) {
			lifePoint = 0;
		}

	}

	// public void attack(Creature other) {
	// int i;
	// for (i = 0; i <= 5; i ++ ) {
	// this.damage() = this.
	// }
	//
	// }

	@Override
	public int getInitialLivePoints() {

		return maxLifePoint;
	}

	public int getRobotCounter() {
		return RobotDamageCounter;
	}

	public void setRobotCounter(int robotCounter) {
		RobotDamageCounter = robotCounter;
	}

}
