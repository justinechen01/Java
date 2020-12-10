package assignment4;
import java.io.PrintWriter;

public class Experiment {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Pair<String,Integer>[] populations = pops(Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
    Population popu = new Population(populations);
    for (int i = 0; i < Integer.parseInt(args[0]); i++) {
      popu.update();
    }
    Pair<String,Integer>[] counts = popu.getPopulationCounts();
    pen.println("After " + Integer.parseInt(args[0]) + " iterations");
    pen.println("Cooperator = " + counts[0].getRight());
    pen.println("Defector = " + counts[0].getRight());
    pen.println("PartialCooperator = " + counts[0].getRight());
    pen.println("Mean Cooperation Probability = " + popu.calculateCooperationMean());

  }
  @SuppressWarnings({"unchecked"})
  public static Pair<String,Integer>[] pops(int numC,int numD, int numP) {
    Pair<String,Integer>[] pop = (Pair<String,Integer>[]) (new Pair[3]);
    pop[0] = new Pair<String, Integer>("Cooperator", numC);
    pop[1] = new Pair<String, Integer>("Defector", numD);
    pop[2] = new Pair<String, Integer>("PartialCooperator", numP);
    return pop;
  }
}