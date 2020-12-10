/**
 * 
 */
package assignment4;

/**
 * @author chenjust
 *
 */
public class PartialCooperator extends Organism{
	
	String name; 
	double cooperationP;
	
	public PartialCooperator(String name) {
		super();
		this.name = name;
		this.cooperationP = 0.5; 
	}
	
	@Override
	public String getType() {
		return "PartialCooperator"; 
	}
	
	@Override 
	public Organism reproduce() {
		return new PartialCooperator(this.name);
	}
	
	@Override
	public double getCooperationProbability() {
		return this.cooperationP;
	}
	
	public boolean cooperates() {
		if(this.cooperationP == 1) {
			return true;
		}else {
			return false; 
		}
		
	}
	

}