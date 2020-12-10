/**
 * 
 */
package assignment4;

/**
 * @author chenjust
 *
 */
public class Defector extends Organism{
	
	String name; 
	double cooperationP;
	
	public Defector(String name) {
		super();
		this.name = name;
		this.cooperationP = 0; 
	}
	
	@Override
	public String getType() {
		return "Defector"; 
	}
	
	@Override 
	public Organism reproduce() {
		return new Defector(this.name);
	}
	
	@Override
	public double getCooperationProbability() {
		return this.cooperationP;
	}
	
	@Override 
	public boolean cooperates() {
		return false;
	}

}
