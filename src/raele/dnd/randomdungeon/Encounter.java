package raele.dnd.randomdungeon;

import java.util.ArrayList;

public class Encounter {
	
	public static class Builder {
		
		private Encounter encounter;
		
		public Builder() {
			this.encounter = new Encounter();
		}
		
		public Builder addRandomMonster() {
			this.encounter.getMonsters().add(new RandomMonster());
			return this;
		}
		
		public Builder addRandomHazard() {
			this.encounter.getHazards().add(new RandomHazard());
			return this;
		}
		
		public Builder addRandomObstacle() {
			this.encounter.getObstacles().add(new RandomObstacle());
			return this;
		}
		
		public Builder addRandomTrap() {
			this.encounter.getTraps().add(new RandomTrap());
			return this;
		}
		
		public Builder addRandomTrick() {
			this.encounter.getTricks().add(new RandomTrick());
			return this;
		}
		
		public Builder setupRandomTreasure(RandomTreasure.Tier tier) {
			this.encounter.setTreasure(new RandomTreasure(tier));
			return this;
		}
		
		public Encounter build() {
			return this.encounter;
		}
		
	}
	
	private ArrayList<RandomMonster> monsters;
	private ArrayList<RandomHazard> hazards;
	private ArrayList<RandomObstacle> obstacles;
	private ArrayList<RandomTrap> traps;
	private ArrayList<RandomTrick> tricks;
	private RandomTreasure treasure;
	
	public Encounter() {
		this.monsters = new ArrayList<>();
		this.hazards = new ArrayList<>();
		this.obstacles = new ArrayList<>();
		this.traps = new ArrayList<>();
		this.tricks = new ArrayList<>();
		this.treasure = null;
	}
	
	public ArrayList<RandomMonster> getMonsters() {
		return monsters;
	}
	public void setMonsters(ArrayList<RandomMonster> monsters) {
		this.monsters = monsters;
	}
	public ArrayList<RandomHazard> getHazards() {
		return hazards;
	}
	public void setHazards(ArrayList<RandomHazard> hazards) {
		this.hazards = hazards;
	}
	public ArrayList<RandomObstacle> getObstacles() {
		return obstacles;
	}
	public void setObstacles(ArrayList<RandomObstacle> obstacles) {
		this.obstacles = obstacles;
	}
	public ArrayList<RandomTrap> getTraps() {
		return traps;
	}
	public void setTraps(ArrayList<RandomTrap> traps) {
		this.traps = traps;
	}
	public ArrayList<RandomTrick> getTricks() {
		return tricks;
	}
	public void setTricks(ArrayList<RandomTrick> tricks) {
		this.tricks = tricks;
	}
	public RandomTreasure getTreasure() {
		return treasure;
	}
	public void setTreasure(RandomTreasure treasure) {
		this.treasure = treasure;
	}
	
}
