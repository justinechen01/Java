/**
 * 
 */
package assignment4;

/**
 * @author chenjust
 *
 */
public class Organism {
	int energy;

	public Organism() {
		this.energy = 0;
	}

	public void update() {
		this.energy++;
		if (this.energy > 10) {
			this.reproduce();
			this.energy = 0;
		}
	}

	public int getEnergy() {
		return this.energy;
	}

	public void incrementEnergy() {
		this.energy++;
	}

	public void decrementEnergy() {
		if (this.energy != 0) {
			this.energy--;
		}

	}

	public String getType() {
		return "";
	}

	public Organism reproduce() {
		return new Organism();
	}

	public double getCooperationProbability() {
		return 0.0;
	}

	public boolean cooperates() {
		return true;
	}
}
