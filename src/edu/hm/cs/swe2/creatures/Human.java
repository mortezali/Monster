package edu.hm.cs.swe2.creatures;

public class Human extends Creature {

	private String name;
	private final static int maxLifePoint = 5;

	// TODO: Siehe CreaturePanel: Hat nur einen String als Parameter.

	public Human(String name) {
		super(name, maxLifePoint);

	}

	@Override
	public int getInitialLivePoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
