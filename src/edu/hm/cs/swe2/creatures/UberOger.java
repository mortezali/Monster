package edu.hm.cs.swe2.creatures;

public class UberOger extends Creature{
	
	 
	
	private String name = "";
	private boolean alreadyDamaged;
	private final static int maxLifePoint = 0;

	public UberOger() {
		super("", maxLifePoint);

	}

	@Override
	public int getInitialLivePoints() {
		// TODO Auto-generated method stub
		return 0;
	}

}
