package edu.hm.cs.swe2.creatures;

public class Robot extends Creature {

	private String name;
	private final static int maxLifePoint = 6;
	private int n;
	
	//TODO: Der Parameter vom Konstruktor ist ein INT
	//In der Creature Panel kannst du das sehen.
	//TODO: name wird in Creature gespeichert. nicht hier.

	public Robot(String name) {
		super(name, maxLifePoint);
		int n = n;

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

}
