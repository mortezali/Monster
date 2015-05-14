package edu.hm.cs.swe2.creatures;

public class Fairy extends Creature{
	
	private String name;
	private final static int maxLifePoint = 4;
	private boolean alreadyDamaged = true;
	
	
	//TODO: Name wird in Creature gespeichert. 
	public Fairy (String name){
		super(name, maxLifePoint);
		
	
		
	}

	public void heal(){
		
		super.heal();
		super.heal();
		
	}
	
	@Override
	public void damage(){
		
		if (this.alreadyDamaged){
			this.lifePoint --;
		}
		alreadyDamaged = !alreadyDamaged;
		
		
		
	}

	@Override
	public int getInitialLivePoints() {

		return maxLifePoint;
	}


}
