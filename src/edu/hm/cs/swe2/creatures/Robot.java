package edu.hm.cs.swe2.creatures;

public class Robot extends Creature {

	private final static int maxLifePoint = 6;
	private int RobotCounter;
	
	//TODO: Der Parameter vom Konstruktor ist ein INT
	//In der Creature Panel kannst du das sehen.
	//TODO: name wird in Creature gespeichert. nicht hier.

	public Robot(int RobotCounter) {
		super(null, maxLifePoint);
	
	}
	public void damage() {
		int i;
		for (i = 0; i <= 5; i++){
			this.lifePoint = this.lifePoint - 0;{
				for (i = 0; i > 5; i --){
					this.lifePoint = this.lifePoint - this.lifePoint;
				}
			}
		}
	
	}
//	public void attack(Creature other) {
//		int i;
//		for (i = 0; i <= 5; i ++ ) {
//			this.damage() = this.
//		}
//
//	}


	@Override
	public int getInitialLivePoints() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getRobotCounter() {
		return RobotCounter;
	}
	public void setRobotCounter(int robotCounter) {
		RobotCounter = robotCounter;
	}
	
}
