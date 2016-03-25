package raele.dnd.randomdungeon;

public class RandomTreasure {
	
	public enum Tier {
		UNDEFINED(null, null, null, null, null),
		LOCAL_HEROES(
				new RandomCopperCoins() {@Override public int generateCopperCoins() {	return Dice.d6.roll(6) * 100;	}},
				new RandomSilverCoins() {@Override public int generateSilverCoins() {	return Dice.d6.roll(3) * 100;	}},
				null,
				new RandomGoldCoins() {@Override public int generateGoldCoins() {	return Dice.d6.roll(2) * 10;	}},
				null
		),
		HEROES_OF_THE_REALM(
				new RandomCopperCoins() {@Override public int generateCopperCoins() {	return Dice.d6.roll(2) * 100;	}},
				new RandomSilverCoins() {@Override public int generateSilverCoins() {	return Dice.d6.roll(2) * 1000;	}},
				null,
				new RandomGoldCoins() {@Override public int generateGoldCoins() {	return Dice.d6.roll(6) * 100;	}},
				new RandomPlatinumCoins() {@Override public int generatePlatinumCoins() {	return Dice.d6.roll(3) * 10;	}}	
		),
		MASTERS_OF_THE_REALM(
				null,
				null,
				null,
				new RandomGoldCoins() {@Override public int generateGoldCoins() {	return Dice.d6.roll(4) * 1000;	}},
				new RandomPlatinumCoins() {@Override public int generatePlatinumCoins() {	return Dice.d6.roll(5) * 100;	}}	
		),
		MASTERS_OF_THE_WORLD(
				null,
				null,
				null,
				new RandomGoldCoins() {@Override public int generateGoldCoins() {	return Dice.d6.roll(12) * 1000;	}},
				new RandomPlatinumCoins() {@Override public int generatePlatinumCoins() {	return Dice.d6.roll(8) * 1000;	}}	
		),
		;
		private interface RandomCopperCoins {	public int generateCopperCoins();	}
		private interface RandomSilverCoins {	public int generateSilverCoins();	}
		private interface RandomEtheriumCoins {	public int generateEtheriumCoins();	}
		private interface RandomGoldCoins {	public int generateGoldCoins();	}
		private interface RandomPlatinumCoins {	public int generatePlatinumCoins();	}

		private RandomCopperCoins copperCoinsGenerator;
		private RandomSilverCoins silverCoinsGenerator;
		private RandomEtheriumCoins etheriumCoinsGenerator;
		private RandomGoldCoins goldCoinsGenerator;
		private RandomPlatinumCoins platinumCoinsGenerator;
		
		private Tier(RandomCopperCoins copperCoinsGenerator,
				RandomSilverCoins silverCoinsGenerator,
				RandomEtheriumCoins etheriumCoinsGenerator,
				RandomGoldCoins goldCoinsGenerator,
				RandomPlatinumCoins platinumCoinsGenerator) {
			this.copperCoinsGenerator = copperCoinsGenerator;
			this.silverCoinsGenerator = silverCoinsGenerator;
			this.etheriumCoinsGenerator = etheriumCoinsGenerator;
			this.goldCoinsGenerator = goldCoinsGenerator;
			this.platinumCoinsGenerator = platinumCoinsGenerator;
		}
		
		public int generateCopperCoins() {
			if (this.copperCoinsGenerator != null) {
				return this.copperCoinsGenerator.generateCopperCoins();
			} else {
				return 0;
			}
		}
		
		public int generateSilverCoins() {
			if (this.silverCoinsGenerator != null) {
				return this.silverCoinsGenerator.generateSilverCoins();
			} else {
				return 0;
			}
		}
		
		public int generateEtheriumCoins() {
			if (this.etheriumCoinsGenerator != null) {
				return this.etheriumCoinsGenerator.generateEtheriumCoins();
			} else {
				return 0;
			}
		}
		
		public int generateGoldCoins() {
			if (this.goldCoinsGenerator != null) {
				return this.goldCoinsGenerator.generateGoldCoins();
			} else {
				return 0;
			}
		}
		
		public int generatePlatinumCoins() {
			if (this.platinumCoinsGenerator != null) {
				return this.platinumCoinsGenerator.generatePlatinumCoins();
			} else {
				return 0;
			}
		}
	}
	
	private Tier tier;
	private int copperCoins;
	private int silverCoins;
	private int etheriumCoins;
	private int goldCoins;
	private int platinumCoins;
	
	public RandomTreasure(Tier tier) {
		this.tier = tier;
		refresh();
	}

	public void refresh() {
		this.copperCoins = this.tier.generateCopperCoins();
		this.silverCoins = this.tier.generateSilverCoins();
		this.etheriumCoins = this.tier.generateEtheriumCoins();
		this.goldCoins = this.tier.generateGoldCoins();
		this.platinumCoins = this.tier.generatePlatinumCoins();
		// TODO generate objects (gemstones, art objects and magic items)
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	public int getCopperCoins() {
		return copperCoins;
	}

	public void setCopperCoins(int copperCoins) {
		this.copperCoins = copperCoins;
	}

	public int getSilverCoins() {
		return silverCoins;
	}

	public void setSilverCoins(int silverCoins) {
		this.silverCoins = silverCoins;
	}

	public int getEtheriumCoins() {
		return etheriumCoins;
	}

	public void setEtheriumCoins(int etheriumCoins) {
		this.etheriumCoins = etheriumCoins;
	}

	public int getGoldCoins() {
		return goldCoins;
	}

	public void setGoldCoins(int goldCoins) {
		this.goldCoins = goldCoins;
	}

	public int getPlatinumCoins() {
		return platinumCoins;
	}

	public void setPlatinumCoins(int platinumCoins) {
		this.platinumCoins = platinumCoins;
	}

}
