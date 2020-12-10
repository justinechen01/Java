/**
 * 
 */
package assignment4;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author chenjust
 *
 */
public class Population {
	Organism[] populations;
	 @SuppressWarnings({"unchecked"})
	public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException {
		int counter = 0;
		this.populations = new Organism[1000];
        for (int i = 0; i < counts.length; i++) {
        	for (int j = 0; j < 3; j++) {
				if (counts[i].getLeft().equals("Cooperator")) {
				populations[counter] = new Cooperator(counts[i].getLeft());
				counter++;
				} else if (counts[i].getLeft().equals("Defector")) {
					populations[counter] = new Defector(counts[i].getLeft());
					counter++;
				} else if (counts[i].getLeft().equals("PartialCooperator")) {
					populations[counter] = new PartialCooperator(counts[i].getLeft());
					counter++;
				} else {
					throw new IllegalArgumentException("Invalid input");
				}
			}
		}

	}

	public void update() {
		for (int i = 0; i > this.populations.length; i++) {
			this.populations[i].update();

			if (this.populations[i].cooperates()) {
				this.populations[i].decrementEnergy();
				ArrayList<Integer> numbers = new ArrayList<Integer>();
				numbers.add(i);
				Random randomGenerator = new Random();
				while (numbers.size() < 9) {

					int random = randomGenerator.nextInt(this.populations.length + 1);
					if (!numbers.contains(random)) {
						numbers.add(random);
					} else {
						numbers.add(random);
						this.populations[random].incrementEnergy();
					}
				}
			}

			if (this.populations[i].getEnergy() >= 10) {
				Random randomGenerator = new Random();
				int random = randomGenerator.nextInt(this.populations.length + 1);			
				this.populations[random] = this.populations[i];
				this.populations[i].energy = 0;
			}
		}
	}

	public double calculateCooperationMean() {
		double sum = 0; 
		for (int i = 0; i < this.populations.length; i++ ) {
			sum += this.populations[i].getCooperationProbability();
		}
		return sum / this.populations.length;
	}
	
	@SuppressWarnings({"unchecked"})
	public Pair<String, Integer>[] getPopulationCounts() {		
		Pair<String,Integer>[] pop = (Pair<String,Integer>[]) (new Pair[3]);
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
	    for (int i = 0;i < this.populations.length;i++) {
	    	if (this.populations[i].getType().equals("Cooperator")) {
	    		counter1++;
	    	} else if (this.populations[i].getType().equals("Defector")) {
	    		counter2++;
	    	} else if (this.populations[i].getType().equals("PartialCooperator")) {
	    		counter3++;
	    	}
	    }
	    pop[0] = new Pair<String, Integer>("Collab", counter1);
	    pop[1] = new Pair<String, Integer>("Defector", counter2);
	    pop[2] = new Pair<String, Integer>("PartialCooperator", counter3);
	    return pop;
	}

}
