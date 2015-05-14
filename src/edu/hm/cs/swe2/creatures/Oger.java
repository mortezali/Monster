package edu.hm.cs.swe2.creatures;

public class Oger extends Creature{
	
	 
		
		private String name = "";
		private boolean alreadyDamaged;
		private final static int maxLifePoint = 0;

		public Oger() {
			super("", maxLifePoint);

		}

		@Override
		public int getInitialLivePoints() {
			// TODO Auto-generated method stub
			return 0;
		}

}
