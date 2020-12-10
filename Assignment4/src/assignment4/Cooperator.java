/**
 * 
 */
package assignment4;

/**
 * @author chenjust
 *
 */
public class Cooperator extends Organism{
	
	String name; 
	double cooperationP;
	
	public Cooperator(String name) {
		super();
		this.name = name;
		this.cooperationP = 1; 
	}
	
	@Override
	public String getType() {
		return "Cooperator"; 
	}
	
	@Override 
	public Organism reproduce() {
		return new Cooperator(this.name);
	}
	
	@Override
	public double getCooperationProbability() {
		return this.cooperationP;
	}
	

}
